import { Injectable } from '@angular/core';

import * as moment from 'moment';

import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  billUrl: string;

  constructor(private http: HttpClient) {
    this.billUrl = `${environment.apiUrl}/v1/bill`;
  }

  lancamentosPorCategoria(): Promise<Array<any>> {
    return firstValueFrom(this.http.get(`${this.billUrl}/users`))
      .then((response : any) => response);
  }

  lancamentosPorDia(): Promise<Array<any>> {
    return firstValueFrom(this.http.get(`${this.billUrl}/estatisticas/por-dia`))
      .then((response : any) => {
        const dados = response;
        this.converterStringsParaDatas(dados);

        return dados;
      });
  }

  private converterStringsParaDatas(dados: Array<any>) {
    for (const dado of dados) {
      dado.dia = moment(dado.dia, 'YYYY-MM-DD').toDate();
    }
  }
}
