import { Injectable } from '@angular/core';
import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Lancamento } from '../core/model';
import { environment } from '../../environments/environment';
import { firstValueFrom } from 'rxjs';

export class DicaFiltro {
  pagina: number = 0
  itensPorPagina: number = 5
}

@Injectable({
  providedIn: 'root'
})
export class DicaService {

  dicaUrl: string;

  constructor(
    private http: HttpClient
  ) {
    this.dicaUrl = `${environment.apiUrl}/v1/tip`
  }

  uploadHeaders() {
    return new HttpHeaders()
      .append('Authorization', 'Bearer ' + localStorage.getItem('token'))
  }

  pesquisar(filtro: DicaFiltro): Promise<any> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

      let params = new HttpParams()
          .set('page', filtro.pagina)
          .set('size', filtro.itensPorPagina);

    return firstValueFrom(this.http.get(`${this.dicaUrl}`, { headers, params }))
      .then((response : any) => {
        const dicas = response['content'];

        const resultado = {
          dicas,
          total: response['totalElements']
        };

        return resultado;
      });
  }

}
