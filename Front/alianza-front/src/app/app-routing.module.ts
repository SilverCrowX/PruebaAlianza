import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminClientComponent } from './components/admin-client/admin-client.component';

const routes: Routes = [
  { path: '**', component: AdminClientComponent },
  {
    path: 'admin-client',
    component: AdminClientComponent 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
