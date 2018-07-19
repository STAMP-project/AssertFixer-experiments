import { NgModule } from '@angular/core';

import { TradebravelySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [TradebravelySharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [TradebravelySharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class TradebravelySharedCommonModule {}
