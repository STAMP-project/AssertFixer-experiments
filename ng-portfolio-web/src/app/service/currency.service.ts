import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class CurrencyService {

  constructor(private http: HttpClient) {
  }

  public getAllCurrencies(): Observable<any> {
    return this.http.get("/api/currency/")
  }

  public create(currency): Observable<any> {
    return this.http.post("/api/currency/", currency)
  }
}
