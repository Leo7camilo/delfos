import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SimulacaoComponent } from './simulacao/simulacao.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { InputTextModule } from 'primeng/inputtext';
import { InputMaskModule } from 'primeng/inputmask';
import { ButtonModule } from 'primeng/button';
import { TooltipModule } from 'primeng/tooltip';
import { TableModule } from 'primeng/table';
import { PanelModule } from 'primeng/panel';
import { DropdownModule } from 'primeng/dropdown';
import { DialogModule } from 'primeng/dialog';
import { SharedModule } from 'primeng/api';
import { SimulacoesRoutingModule } from './simulacoes-routing.module';
import {CheckboxModule} from 'primeng/checkbox';

import {CardModule} from 'primeng/card';


@NgModule({
  declarations: [
    SimulacaoComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,

    InputTextModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    InputMaskModule,
    PanelModule,
    DialogModule,
    DropdownModule,
    CheckboxModule,
    CardModule,

    SharedModule,
    SimulacoesRoutingModule
  ]
})
export class SimulacoesModule { }
