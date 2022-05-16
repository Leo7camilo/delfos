import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {TimelineModule} from 'primeng/timeline';

import { DicaPesquisaComponent } from './dica-pesquisa/dica-pesquisa.component';


@NgModule({
  declarations: [
    DicaPesquisaComponent
  ],
  imports: [
    CommonModule,

    TimelineModule
  ]
})
export class DicaModule { }
