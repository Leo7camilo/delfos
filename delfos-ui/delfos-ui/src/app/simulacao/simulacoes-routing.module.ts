import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { SimulacaoComponent } from './simulacao/simulacao.component';



const routes: Routes = [
    { path: '', component: SimulacaoComponent },
  ];

  @NgModule({
    imports: [
      RouterModule.forChild(routes)
    ],
    exports: [RouterModule]
  })
  export class SimulacoesRoutingModule { }
