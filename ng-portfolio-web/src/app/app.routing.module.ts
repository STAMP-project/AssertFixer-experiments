import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ErrorPageComponent} from "./error-page/error-page.component";
import {HomePageComponent} from "./home-page/home-page.component";
import {CurrencyPageComponent} from "./currency/currency-page.component";
import {ActuatorComponent} from "./admin/actuator.component";

/**
 * Route Definition of the application and link to Component
 */
const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'currency', component: CurrencyPageComponent},
  {path: 'sysview', component: ActuatorComponent},
  {path: '**', component: ErrorPageComponent, data: {error: 404}}
];

/**
 * Separate NgModule declaration for routing
 */
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
