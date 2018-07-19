import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { ITransaction } from 'app/shared/model/transaction.model';
import { TransactionService } from './transaction.service';

@Component({
    selector: 'jhi-transaction-update',
    templateUrl: './transaction-update.component.html'
})
export class TransactionUpdateComponent implements OnInit {
    private _transaction: ITransaction;
    isSaving: boolean;
    date: string;

    constructor(private transactionService: TransactionService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ transaction }) => {
            this.transaction = transaction;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.transaction.date = moment(this.date, DATE_TIME_FORMAT);
        if (this.transaction.id !== undefined) {
            this.subscribeToSaveResponse(this.transactionService.update(this.transaction));
        } else {
            this.subscribeToSaveResponse(this.transactionService.create(this.transaction));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ITransaction>>) {
        result.subscribe((res: HttpResponse<ITransaction>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get transaction() {
        return this._transaction;
    }

    set transaction(transaction: ITransaction) {
        this._transaction = transaction;
        this.date = moment(transaction.date).format(DATE_TIME_FORMAT);
    }
}
