import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroUsuarioComponent } from '../cadastro/cadastro-usuario/cadastro-usuario.component';
import { AuthorizedComponent } from './authorized/authorized.component';
import { LoginFormComponent } from './login-form/login-form.component';

const routes: Routes = [
  /*{
    path: 'authorized',
    component: AuthorizedComponent
  },*/
  { path: 'login', component: LoginFormComponent },
  { path: 'cadastrar', component: CadastroUsuarioComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SegurancaRoutingModule { }
