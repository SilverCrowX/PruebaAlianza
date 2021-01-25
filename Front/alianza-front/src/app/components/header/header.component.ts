import { Component, OnInit } from '@angular/core';
import { ClientService } from 'src/app/services/client.service';
import { DialogComponent } from '../dialog/dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  valueFilter: string;

  constructor(private clientService: ClientService, public dialog: MatDialog) {
    this.valueFilter = '';
  }





  ngOnInit(): void {}

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

  openDialog(): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '250px',
      
    });

  }
}
