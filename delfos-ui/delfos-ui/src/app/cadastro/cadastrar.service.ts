import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { environment } from 'src/environments/environment';
import * as CryptoJS from 'crypto-js';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthCadastroService {

  apiUrlUser = environment.apiUrl+'/v1/user'

  constructor(
    private http: HttpClient
  ) {
  }

  cadastrar(name: any, cpf: any, email: any, cep: any, password: any) {
    const headers = new HttpHeaders()
      .append('Content-Type', 'application/json')

      const body = {
        document: {
          type: 1,
          documentNumber: cpf
        },
        name: name,
        email: email,
        state: 'ATIVO',
        type: 'COMMUNAL',
        cep: cep,
        password: password
      }

      return this.http.post(this.apiUrlUser, body, { headers})
      .toPromise()
      .then((response:any) => {
        //this.armazenarToken(response['access_token']);
      })
      .catch(response => {
        if (response.status === 400) {
            return Promise.reject(response.error[0].mensagemUsuario);
        }

        return Promise.reject(response);
      });

  }
}
