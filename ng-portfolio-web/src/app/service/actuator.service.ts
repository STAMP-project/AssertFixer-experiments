import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class ActuatorService {

  constructor(private http: HttpClient) {
  }

  public getHealth(): Observable<any> {
    return this.http.get("/actuator/health")
  }

  public getInfo(): Observable<any> {
    return this.http.get("/actuator/info")
  }

  public getMetrics(): Observable<any> {
    return this.http.get("/actuator/metrics")
  }

}
