import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  constructor(private http: HttpClient) {}

  getFilterClients(valueFilter: string): Observable<Client> {
    return new Observable();
  }

  getClients(): Observable<any> {
    const url = 'http://localhost:8080/Alianza/Client/findAll';

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };
    return this.http.get(url, httpOptions);
  }

  createCliente(obj: Client): Observable<any> {
    const url = 'http://localhost:8080/Alianza/Client/create';

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };
    let json = JSON.stringify(obj);
    return this.http.post(url, obj, httpOptions);
  }

  getClient(sharedKey: any): Observable<any> {
    const url = `http://localhost:8080/Alianza/Client/findBySharedKey`;
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      hparams: new HttpParams().set('key', sharedKey),
    };
    return this.http.get(url, {
      headers: httpOptions.headers,
      params: httpOptions.hparams,
    });
  }
}
