import { MessageService } from 'primeng/api';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ErrorHandlerService } from 'src/app/core/error-handler.service';
import { AuthCadastroService } from '../cadastrar.service';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.css']
})
export class CadastroUsuarioComponent implements OnInit {

  constructor(
    private auth: AuthCadastroService,
    private errorHandler: ErrorHandlerService,
    private router: Router,
    private messageService: MessageService
  ) { }

  ngOnInit(): void {
  }

  cadastrar(name: any, cpf: any, email: any, cep: any, password: any) {
    this.auth.cadastrar(name, cpf, email, cep, password)
      .then(() => {
        this.messageService.add({ severity:'success', detail: 'Usuario criado com sucesso' });
        this.router.navigate(['/login']);
      })
      .catch(erro => {
        this.errorHandler.handle(erro);
      });
  }

}
