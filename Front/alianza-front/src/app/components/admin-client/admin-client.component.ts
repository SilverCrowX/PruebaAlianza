import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-admin-client',
  templateUrl: './admin-client.component.html',
  styleUrls: ['./admin-client.component.scss'],
})
export class AdminClientComponent implements OnInit {
  showFiller = false;
  valueFilter: string = '';
  displayedColumns: string[] = [
    'sharedKey',
    'business',
    'email',
    'phone',
    'date',
    'action',
  ];

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

  constructor(private clientService: ClientService, public dialog: MatDialog) {}

  openDialog(): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '250px',
      data: new Client(),
    });

    dialogRef.beforeClosed().subscribe(() => {
      this.getDateClient();
    });
  }

  ngOnInit(): void {
    this.getDateClient();
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

  searchClient() {
    this.clientService.getClient(this.valueFilter).subscribe(
      (data: any) => {
        //this.clients = data;
        this.dataSource = new MatTableDataSource(data);
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
