import { NaoAutorizadoComponent } from './core/nao-autorizado.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PaginaNaoEncontradaComponent } from './core/pagina-nao-encontrada.component';

const routes: Routes = [
    { path: 'dashboard', loadChildren: () => import('../app/dashboard/dashboard.module').then(m => m.DashboardModule) },
    { path: 'bandeira', loadChildren: () => import('../app/bandeira/bandeira.module').then(m => m.BandeiraModule) },
    { path: 'dica', loadChildren: () => import('../app/dica/dica.module').then(m => m.DicaModule) },
    { path: 'pessoas', loadChildren: () => import('../app/pessoas/pessoas.module').then(m => m.PessoasModule) },
    { path: 'simulacoes', loadChildren: () => import('../app/simulacao/simulacoes.module').then(m => m.SimulacoesModule) },
    { path: 'cadastrar', loadChildren: () => import('../app/cadastro/cadastro.module').then(m => m.CadastroModule) },

    { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
    { path: 'nao-autorizado', component: NaoAutorizadoComponent },
    { path: 'pagina-nao-encontrada', component: PaginaNaoEncontradaComponent },
    { path: '**', redirectTo: 'pagina-nao-encontrada' }
  ];

  @NgModule({
    imports: [
      RouterModule.forRoot(routes)
    ],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
