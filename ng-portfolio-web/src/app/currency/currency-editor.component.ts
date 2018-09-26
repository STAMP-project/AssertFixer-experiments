import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {CurrencyService} from "../service/currency.service";
import {NotificationComponent} from "../notification/notification.component";

@Component({
  selector: 'bs-currency-editor',
  templateUrl: './currency-editor.component.html',
  styleUrls: ['./currency-editor.component.css'],
  providers: [CurrencyService, NotificationComponent]
})
export class CurrencyEditorComponent implements OnInit {

  @Output()
  onSave = new EventEmitter();

  currencyForm = new FormGroup({
    iso: new FormControl(''),
    name: new FormControl(''),
  });

  constructor(private currencyService: CurrencyService, private notification: NotificationComponent) {
  }

  ngOnInit() {
  }

  save() {
    this.currencyService.create(this.currencyForm.value)
      .subscribe(value => {
        //this.currencyForm.setValue();
        this.onSave.emit(value)
      }, err => this.notification.httpError(err));
  };

  cancel() {
  };
}
