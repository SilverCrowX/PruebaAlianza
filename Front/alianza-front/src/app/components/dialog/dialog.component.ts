import {Component, Inject} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Client } from 'src/app/model/client';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss']
})
export class DialogComponent {

  userForm: FormGroup =  this.formBuilder.group({
    name: ['', [Validators.required, Validators.maxLength(50)]],
    phone: ['', [Validators.required, Validators.maxLength(50)]],
    email: ['', [Validators.required, Validators.maxLength(50), Validators.email]],
    datestart: ['', [Validators.required]],
    dateend: ['', [Validators.required]]
  });

  clientForm: Client = new Client();

  constructor(
    public dialogRef: MatDialogRef<DialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Client,
    private formBuilder: FormBuilder,
    private clientService: ClientService) {}

  createNewClient(): void {
    this.clientService.createCliente(this.clientForm).subscribe(
      (data: any) => {
        //this.clients = data;
        this.dialogRef.close();
      },
      (err) => {
        console.log(err);
      }
    );
    
    
  }
}
