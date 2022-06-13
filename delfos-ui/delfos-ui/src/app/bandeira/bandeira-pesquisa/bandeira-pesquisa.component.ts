import { BanderiaService } from './../bandeira.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bandeira-pesquisa',
  templateUrl: './bandeira-pesquisa.component.html',
  styleUrls: ['./bandeira-pesquisa.component.css']
})
export class BandeiraPesquisaComponent implements OnInit {

  bandeiraData: any;

  constructor(
    private banderiaService: BanderiaService
  ) { }

  ngOnInit(): void {

    this.pesquisarBandeira();
  }

  pesquisarBandeira(){
    this.banderiaService.pesquisar()
      .then(dados => {
        console.log("Olaaaa "+ JSON.stringify(dados));
        this.bandeiraData = dados;
      });
  }

}
