import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { TradebravelyTransactionModule } from './transaction/transaction.module';
import { TradebravelyTaxModule } from './tax/tax.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        TradebravelyTransactionModule,
        TradebravelyTaxModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TradebravelyEntityModule {}
