import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {Observable, Subscription} from "rxjs";
import {CurrencyService} from "../service/currency.service";
import {NotificationComponent} from "../notification/notification.component";

@Component({
  selector: 'bs-currency-table',
  templateUrl: './currency-table.component.html',
  styleUrls: ['./currency-table.component.css'],
  providers: [CurrencyService, NotificationComponent]
})
export class CurrencyTableComponent implements OnInit, OnDestroy {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  public displayedColumns: string[] = ['iso', 'name', 'exchange'];
  public dataSource: MatTableDataSource<any>;
  private currencySubscription: Subscription;
  private currencyObservable: Observable<any>;
  private currencies: any[];

  constructor(private currencyService: CurrencyService, private notification: NotificationComponent) {
    this.dataSource = new MatTableDataSource([]);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngOnInit() {
    this.refresh();
  }

  public refresh() {
    this.currencyObservable = this.currencyService.getAllCurrencies();
    this.currencySubscription = this.currencyObservable.subscribe(value => {
        this.currencies = value;
        this.dataSource = new MatTableDataSource(value);
        this.dataSource.paginator = this.paginator;
        this.dataSource.paginator.firstPage();
        this.dataSource.sort = this.sort;
      }, err => this.notification.error(err)
    );
  }

  ngOnDestroy() {
    if (this.currencySubscription) {
      this.currencySubscription.unsubscribe();
    }
  }
}
