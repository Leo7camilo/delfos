import { Component, OnInit } from '@angular/core';
import { PrimeIcons } from 'primeng/api';
import { DicaService } from '../dica.service';

@Component({
  selector: 'app-dica-pesquisa',
  templateUrl: './dica-pesquisa.component.html',
  styleUrls: ['./dica-pesquisa.component.css']
})
export class DicaPesquisaComponent implements OnInit {

  dicaData: any;

  events1: any[] = [];
  events2: any[] = [];

  constructor(
    private dicaService: DicaService
  ) { }

  ngOnInit(): void {

    this.events1 = [
      {status: 'Ordered', date: '15/10/2020 10:30', icon: PrimeIcons.SHOPPING_CART, color: '#9C27B0', image: 'game-controller.jpg'},
      {status: 'Processing', date: '15/10/2020 14:00', icon: PrimeIcons.COG, color: '#673AB7'},
      {status: 'Shipped', date: '15/10/2020 16:15', icon: PrimeIcons.ENVELOPE, color: '#FF9800'},
      {status: 'Delivered', date: '16/10/2020 10:00', icon: PrimeIcons.CHECK, color: '#607D8B'}
  ];

  this.events2 = [
      "2020", "2021", "2022", "2023"
  ];

    this.pesquisarBandeira();
  }

  pesquisarBandeira(){
    this.dicaService.pesquisar()
      .then(dados => {
        console.log("Olaaaa "+ JSON.stringify(dados));
        this.dicaData = dados;
      });
  }
}
