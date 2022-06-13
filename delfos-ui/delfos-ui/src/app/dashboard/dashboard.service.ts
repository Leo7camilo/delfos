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

  lancamentosPorUsuarioMensal(userId: string): Promise<Array<any>> {
    return firstValueFrom(this.http.get(`${this.billUrl}/statistics/by-user/${userId}`))
      .then((response : any) => response);
  }

  lancamentosPorUsuarioPorDia(userId: string): Promise<Array<any>> {
    return firstValueFrom(this.http.get(`${this.billUrl}/statistics/by-day/${userId}`))
      .then((response : any) => {
        const dados = response;
        this.converterStringsParaDatas(dados);

        return dados;
      });
  }

  private converterStringsParaDatas(dados: Array<any>) {
    for (const dado of dados) {
      dado.date = moment(dado.date, 'YYYY-MM-DD').toDate();
    }
  }
}
