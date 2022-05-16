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

  pesquisar(): Promise<any> {
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic YWRtaW5AYWxnYW1vbmV5LmNvbTphZG1pbg==');

    return firstValueFrom(this.http.get(`${this.dicaUrl}`, { headers }))
      .then((response : any) => {
        const dica = response;
        console.log(response);
        return response;
      });
  }

}
