import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NavigationComponent} from './navigation/navigation.component';
import {LayoutModule} from '@angular/cdk/layout';
import {ErrorPageComponent} from './error-page/error-page.component';
import {HomePageComponent} from './home-page/home-page.component';
import {AppRoutingModule} from "./app.routing.module";
import {CurrencyPageComponent} from './currency/currency-page.component';
import {HttpClientModule} from '@angular/common/http';
import {
  MatButtonModule,
  MatCardModule,
  MatChipsModule,
  MatExpansionModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatPaginatorModule,
  MatSidenavModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {NotificationComponent} from './notification/notification.component';
import {ActuatorComponent} from './admin/actuator.component';
import {CurrencyTableComponent} from './currency/currency-table.component';
import {CurrencyEditorComponent} from './currency/currency-editor.component';
import {FlexLayoutModule} from "@angular/flex-layout";
import {ReactiveFormsModule} from "@angular/forms";
import {CurrencyChartComponent} from './currency/currency-chart.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    ErrorPageComponent,
    HomePageComponent,
    CurrencyPageComponent,
    NotificationComponent,
    ActuatorComponent,
    CurrencyTableComponent,
    CurrencyEditorComponent,
    CurrencyChartComponent
  ],
  imports: [
    ReactiveFormsModule,
    FlexLayoutModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatCardModule,
    MatInputModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatChipsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatSnackBarModule,
    MatExpansionModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
