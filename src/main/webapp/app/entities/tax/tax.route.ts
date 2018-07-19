import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Tax } from 'app/shared/model/tax.model';
import { TaxService } from './tax.service';
import { TaxComponent } from './tax.component';
import { TaxDetailComponent } from './tax-detail.component';
import { TaxUpdateComponent } from './tax-update.component';
import { TaxDeletePopupComponent } from './tax-delete-dialog.component';
import { ITax } from 'app/shared/model/tax.model';

@Injectable({ providedIn: 'root' })
export class TaxResolve implements Resolve<ITax> {
    constructor(private service: TaxService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((tax: HttpResponse<Tax>) => tax.body));
        }
        return of(new Tax());
    }
}

export const taxRoute: Routes = [
    {
        path: 'tax',
        component: TaxComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'Taxes'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'tax/:id/view',
        component: TaxDetailComponent,
        resolve: {
            tax: TaxResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Taxes'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'tax/new',
        component: TaxUpdateComponent,
        resolve: {
            tax: TaxResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Taxes'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'tax/:id/edit',
        component: TaxUpdateComponent,
        resolve: {
            tax: TaxResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Taxes'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const taxPopupRoute: Routes = [
    {
        path: 'tax/:id/delete',
        component: TaxDeletePopupComponent,
        resolve: {
            tax: TaxResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Taxes'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
