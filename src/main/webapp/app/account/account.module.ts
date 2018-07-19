import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TradebravelySharedModule } from 'app/shared';

import { SettingsComponent, accountState } from './';

@NgModule({
    imports: [TradebravelySharedModule, RouterModule.forChild(accountState)],
    declarations: [SettingsComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TradebravelyAccountModule {}
