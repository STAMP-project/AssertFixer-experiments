import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

import { TaskService } from 'app/workplace/services/task.service';
import { RemoveConfirmationService } from 'app/services/remove-confirmation/remove-confirmation.service';

import {convertToCustomAttributes, saveCustomAttributes, CustomAttribute, Task} from 'app/workplace/models/task';
import {ErrorModel} from '../../models/modal-error';
import {ErrorModalService} from '../../services/errorModal/error-modal.service';

@Component({
  selector: 'taskana-task-details',
  templateUrl: './taskdetails.component.html',
  styleUrls: ['./taskdetails.component.scss']
})
export class TaskdetailsComponent implements OnInit, OnDestroy {
  task: Task = null;
  customAttributes: CustomAttribute[] = [];
  requestInProgress = false;
  tabSelected = 'general';

  private routeSubscription: Subscription;


  constructor(private route: ActivatedRoute,
    private taskService: TaskService,
    private router: Router,
    private removeConfirmationService: RemoveConfirmationService,
    private errorModalService: ErrorModalService) {
  }

  ngOnInit() {
    this.routeSubscription = this.route.params.subscribe(params => {
      const id = params['id'];
      this.getTask(id);
    });
  }

  getTask(id: string): void {
    this.requestInProgress = true;
    this.taskService.getTask(id).subscribe(task => {
      this.requestInProgress = false;
      this.task = task;
      this.taskService.selectTask(task);
      this.customAttributes = convertToCustomAttributes.bind(this.task)();
    }, err => {
      this.errorModalService.triggerError(
        new ErrorModel('An error occurred while fetching the task', err));
    });
  }

  updateTask() {
    this.requestInProgress = true;
    saveCustomAttributes.bind(this.task)(this.customAttributes);
    this.taskService.updateTask(this.task).subscribe(task => {
      this.requestInProgress = false;
      this.task = task;
      this.taskService.publishUpdatedTask(task);
      this.customAttributes = convertToCustomAttributes.bind(this.task)();
    });
  }

  openTask(taskId: string) {
    this.router.navigate([{ outlets: { detail: `task/${taskId}` } }], { relativeTo: this.route.parent });
  }

  workOnTaskDisabled(): boolean {
    return this.task ? this.task.state === 'COMPLETED' : false;
  }

  deleteTask(): void {
    this.removeConfirmationService.setRemoveConfirmation(this.deleteTaskConfirmation.bind(this),
      `You are going to delete Task: ${this.task.taskId}. Can you confirm this action?`);
  }


  deleteTaskConfirmation(): void {
    this.taskService.deleteTask(this.task).subscribe();
    this.taskService.publishDeletedTask(this.task);
    this.task = null;
    this.customAttributes = [];
    this.router.navigate([`/workplace/tasks`]);
  }

  selectTab(tab: string): void {
    this.tabSelected = tab;
  }

  backClicked(): void {
    this.task = undefined;
    this.taskService.selectTask(this.task);
    this.router.navigate(['./'], { relativeTo: this.route.parent });
  }

  addCustomAttribute(): void {
    this.customAttributes.push({ key: '', value: '' });
  }

  removeCustomAttribute(idx: number): void {
    this.customAttributes.splice(idx, 1);
  }

  ngOnDestroy(): void {
    if (this.routeSubscription) {
      this.routeSubscription.unsubscribe();
    }
  }
}
