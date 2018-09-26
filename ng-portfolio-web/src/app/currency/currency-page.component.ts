import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {CurrencyService} from "../service/currency.service";
import {NotificationComponent} from "../notification/notification.component";
import {CurrencyTableComponent} from "./currency-table.component";

@Component({
  selector: 'bs-currency-page',
  templateUrl: './currency-page.component.html',
  styleUrls: ['./currency-page.component.css'],
  providers: [CurrencyService, NotificationComponent]
})
export class CurrencyPageComponent implements OnInit, OnDestroy {

  @ViewChild(CurrencyTableComponent)
  private currencyTableComponent: CurrencyTableComponent;

  ngOnInit() {
  }

  saveCurrency(currency) {
    this.currencyTableComponent.refresh();
  }
  
  ngOnDestroy() {
  }

}
