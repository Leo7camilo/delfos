import { BillStaticsUser } from './../../shared/bill-statitics-user';
import { Component, OnInit } from '@angular/core';

import { DashboardService } from './../dashboard.service';
import { DecimalPipe } from '@angular/common';
import { AuthService } from 'src/app/seguranca/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  pieChartData: any;
  lineChartData: any;

  billStaticsUser!: BillStaticsUser;


  usuarioLogado: string = ''

  options = {
    tooltips: {
      callbacks: {
        label: (tooltipItem:any, data:any) => {
          const dataset = data.datasets[tooltipItem.datasetIndex];
          const valor = dataset.data[tooltipItem.index];
          const label = dataset.label ? (dataset.label + ': ') : '';

          return label + this.decimalPipe.transform(valor, '1.2-2');
        }
      }
    }
  };

  constructor(
    public auth: AuthService,
    private dashboardService: DashboardService,
    private decimalPipe: DecimalPipe) { }

  ngOnInit() {

    this.usuarioLogado = this.auth.jwtPayload?.email;

    this.configurarGraficoPizza();
    this.configurarGraficoLinha();
  }

  configurarGraficoPizza() {
    this.dashboardService.lancamentosPorUsuarioMensal(this.usuarioLogado)
      .then(dados => {

        this.pieChartData = {
          labels: dados.map(dado => dado.type),
          datasets: [
            {
              data: dados.map(dado => dado.cashValue),
              backgroundColor: ['#060208', '#605e61', '#990099', '#3B3EAC', '#0099C6',
                                  '#DD4477', '#3366CC', '#DC3912']
            }
          ]
        };
      });
  }

  configurarGraficoLinha() {
    this.dashboardService.lancamentosPorUsuarioPorDia(this.usuarioLogado)
      .then(dados => {
        const diasDoMes = this.configurarDiasMes();
        const totaisReceitas = this.totaisPorCadaDiaMes(
          dados.filter(dado => dado.type === 'ENERGIA'), diasDoMes);
        const totaisDespesas = this.totaisPorCadaDiaMes(
          dados.filter(dado => dado.type === 'KWH'), diasDoMes);


        this.lineChartData = {
          labels: diasDoMes,
          datasets: [
            {
              label: 'Em reais',
              data: totaisReceitas,
              borderColor: '#060208'
            },
            {
              label: 'Kwh',
              data: totaisDespesas,
              borderColor: '#605e61'
            }
          ]
        }
      });
  }

  private totaisPorCadaDiaMes(dados:any, diasDoMes:any) {
    const totais: number[] = [];
    for (const dia of diasDoMes) {
      let total = 0;

      for (const dado of dados) {
        if (dado.date.getDate() === dia) {
          total = dado.cashValue;

          break;
        }
      }

      totais.push(total);
    }

    return totais;
  }

  private configurarDiasMes() {
    const mesReferencia = new Date();
    mesReferencia.setMonth(mesReferencia.getMonth() + 1);
    mesReferencia.setDate(0);

    const quantidade = mesReferencia.getDate();

    const dias: number[] = [];

    for (let i = 1; i <= quantidade; i++) {
      dias.push(i);
    }

    return dias;
  }
}
