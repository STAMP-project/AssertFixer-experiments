import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITax } from 'app/shared/model/tax.model';

type EntityResponseType = HttpResponse<ITax>;
type EntityArrayResponseType = HttpResponse<ITax[]>;

@Injectable({ providedIn: 'root' })
export class TaxService {
    private resourceUrl = SERVER_API_URL + 'api/taxes';

    constructor(private http: HttpClient) {}

    create(tax: ITax): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(tax);
        return this.http
            .post<ITax>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(tax: ITax): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(tax);
        return this.http
            .put<ITax>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: string): Observable<EntityResponseType> {
        return this.http
            .get<ITax>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<ITax[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: string): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(tax: ITax): ITax {
        const copy: ITax = Object.assign({}, tax, {
            date: tax.date != null && tax.date.isValid() ? tax.date.toJSON() : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.date = res.body.date != null ? moment(res.body.date) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((tax: ITax) => {
            tax.date = tax.date != null ? moment(tax.date) : null;
        });
        return res;
    }
}
