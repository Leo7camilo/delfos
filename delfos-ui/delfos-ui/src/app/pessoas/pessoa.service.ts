import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Cidade, Estado, Pessoa } from '../core/model';
import { firstValueFrom } from 'rxjs';

export class PessoaFiltro {
  email?: string;
  pagina: number = 0;
  itensPorPagina: number = 5;
}

@Injectable({
  providedIn: 'root'
})
export class PessoaService {
  userUrl: string;

  constructor(private http: HttpClient) {
    this.userUrl = `${environment.apiUrl}/v1/user`;
  }

  pesquisar(filtro: PessoaFiltro) : Promise<any> {

    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    let params = new HttpParams()
                      .set('page', filtro.pagina)
                      .set('size', filtro.itensPorPagina);

    if (filtro.email) {
      params = params.set('email', filtro.email);
    }

    return firstValueFrom(
        this.http.get(`${this.userUrl}`, { headers, params })
      )
      .then((response : any) => {
        const pessoas = response['content'];

        const resultado = {
          pessoas,
          total: response['totalElements']
        };

        return resultado;
      });
  }

  listarTodas() : Promise<any> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    return firstValueFrom(
        this.http.get(this.userUrl, { headers })
      )
      .then((response: any) => response['content']);
  }

  excluir(codigo: number) : Promise<void> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    return firstValueFrom(this.http.delete<void>(`${this.userUrl}/${codigo}`, { headers }));
  }

  mudarStatus(codigo: number, ativo: boolean): Promise<void> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==')
      .append('Content-Type', 'application/json');

    return firstValueFrom(this.http.put<void>(`${this.userUrl}/${codigo}/ativo`, ativo, { headers }));
  }

  adicionar(pessoa: Pessoa): Promise<Pessoa> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==')
      .append('Content-Type', 'application/json');

    return firstValueFrom(this.http.post<Pessoa>(this.userUrl, pessoa, { headers }));
  }

  atualizar(pessoa: Pessoa): Promise<Pessoa> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==')
      .append('Content-Type', 'application/json');

    return firstValueFrom(this.http.put<Pessoa>(`${this.userUrl}/${pessoa.codigo}`, pessoa, { headers }));
  }

  buscarPorCodigo(codigo: number): Promise<Pessoa> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    return firstValueFrom(this.http.get<Pessoa>(`${this.userUrl}/${codigo}`, { headers }));
  }

}
