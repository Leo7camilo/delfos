import { DicaPesquisaComponent } from './dica-pesquisa/dica-pesquisa.component';
import { AuthGuard } from '../seguranca/auth.guard';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';



const routes: Routes = [
    {
      path: '',
      component: DicaPesquisaComponent,
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
  export class DicaRoutingModule { }
