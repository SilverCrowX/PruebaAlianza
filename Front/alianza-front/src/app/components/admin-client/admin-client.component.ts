import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-admin-client',
  templateUrl: './admin-client.component.html',
  styleUrls: ['./admin-client.component.scss'],
})
export class AdminClientComponent implements OnInit {
  showFiller = false;

  displayedColumns: string[] = [
    'sharedKey',
    'business',
    'email',
    'phone',
    'date',
    'action',
  ];

  valueFilter: string;
  clients: Client[] = [];
  /*
  clients: Client[] = [
    {
      key: 'key',
      businessId: 'Julian',
      number: 123456789,
      email: 'correo@correo.com',
      date: '20/05/2020'
    }
  ];
  */
  clientForm: Client = new Client();

  dataSource = new MatTableDataSource(this.clients);

  constructor(private clientService: ClientService, public dialog: MatDialog) {
    this.valueFilter = '';
  }

  ngOnInit(): void {
    this.getDateClient();
  }

  getClientsFilter() {
    this.clientService.getFilterClients(this.valueFilter).subscribe(
      (data: any) => {
        console.log(data);
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getDateClient() {
    this.clientService.getClients().subscribe(
      (data: any) => {
        //this.clients = data;
        this.dataSource = new MatTableDataSource(data);
      },
      (err) => {
        console.log(err);
      }
    );
  }

  modifyClient(clientModify: Client) {
    this.clientForm = clientModify;
  }
}
