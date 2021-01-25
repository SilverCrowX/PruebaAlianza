import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http: HttpClient) { }
  
  
  getFilterClients(valueFilter: string): Observable<Client>{    
    return new Observable;
  }

  getClients(): Observable<any>{
    const url = 'http://localhost:8080/Alianza/Client/findAll';

    const httpOptions = {
      headers: new HttpHeaders(
        {
          'Content-Type': 'application/json'
        }
      )
    };
    return this.http.get(url, httpOptions);
  }
  
}
