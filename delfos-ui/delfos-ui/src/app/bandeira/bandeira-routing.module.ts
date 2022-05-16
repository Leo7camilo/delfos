import { AuthGuard } from '../seguranca/auth.guard';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BandeiraPesquisaComponent } from './bandeira-pesquisa/bandeira-pesquisa.component';



const routes: Routes = [
    {
      path: '',
      component: BandeiraPesquisaComponent,
      canActivate: [AuthGuard],
      data: { roles: ['ROLE_SEARCH_BILL'] }
    }
  ];

  @NgModule({
    imports: [
      RouterModule.forChild(routes)
    ],
    exports: [RouterModule]
  })
  export class BandeiraRoutingModule { }
