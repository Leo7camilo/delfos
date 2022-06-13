import { Injectable } from '@angular/core';
import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Lancamento } from '../core/model';
import { environment } from '../../environments/environment';
import { firstValueFrom } from 'rxjs';

export class LancamentoFiltro {
  descricao?: string
  dataVencimentoInicio?: Date
  dataVencimentoFim?: Date
  pagina: number = 0
  itensPorPagina: number = 5
}

@Injectable({
  providedIn: 'root'
})
export class BanderiaService {

  bandeiraUrl: string;

  constructor(
    private http: HttpClient
  ) {
    this.bandeiraUrl = `${environment.apiUrl}/v1/flag`
  }

  uploadHeaders() {
    return new HttpHeaders()
      .append('Authorization', 'Bearer ' + localStorage.getItem('token'))
  }

  pesquisar(): Promise<any> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    return firstValueFrom(this.http.get(`${this.bandeiraUrl}`, { headers }))
      .then((response : any) => {
        const bandeira = response;
        console.log(bandeira);

        const resultado = {
          bandeira: bandeira,
          total: 1
        };

        return resultado;
      });
  }

  pesquisarTodas(): Promise<any> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    return firstValueFrom(this.http.get(`${this.bandeiraUrl}/list`, { headers }))
      .then((response : any) => {
        const bandeira = response;

        const resultado = {
          bandeira: bandeira,
          total: 4
        };

        return resultado;
      });
  }

}
