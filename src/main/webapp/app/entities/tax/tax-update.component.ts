import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { ITax } from 'app/shared/model/tax.model';
import { TaxService } from './tax.service';

@Component({
    selector: 'jhi-tax-update',
    templateUrl: './tax-update.component.html'
})
export class TaxUpdateComponent implements OnInit {
    private _tax: ITax;
    isSaving: boolean;
    date: string;

    constructor(private taxService: TaxService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ tax }) => {
            this.tax = tax;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.tax.date = moment(this.date, DATE_TIME_FORMAT);
        if (this.tax.id !== undefined) {
            this.subscribeToSaveResponse(this.taxService.update(this.tax));
        } else {
            this.subscribeToSaveResponse(this.taxService.create(this.tax));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ITax>>) {
        result.subscribe((res: HttpResponse<ITax>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get tax() {
        return this._tax;
    }

    set tax(tax: ITax) {
        this._tax = tax;
        this.date = moment(tax.date).format(DATE_TIME_FORMAT);
    }
}
