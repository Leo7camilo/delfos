import { Component, OnInit } from '@angular/core';
import { BanderiaService } from 'src/app/bandeira/bandeira.service';
import { AuthService } from 'src/app/seguranca/auth.service';



interface Equipamentos {
  nome: string,
  watts: number
}

interface Bandeira {
  id: number,
  type: string,
  description: string
}

@Component({
  selector: 'app-simulacao',
  templateUrl: './simulacao.component.html',
  styleUrls: ['./simulacao.component.css']
})
export class SimulacaoComponent implements OnInit {

  equipamentos: Equipamentos[];
  selectedEquipamentos: Equipamentos | undefined;
  mostraCard: boolean = false;

  bandeiras: Bandeira[];
  selectedBandeiras: Bandeira;


  usuarioLogado: string = ''
  constructor(
    public auth: AuthService,
    private banderiaService: BanderiaService
  ) {
    this.equipamentos = [
      { nome: 'Chuveiro', watts: 7000 },
      { nome: 'Chuveiro', watts: 5000 },
      { nome: 'Geladeira', watts: 250 },
    ];

    this.bandeiras = [];
    let bandeira: Bandeira = {
      id: 0,
      type: '',
      description: ''
    }
    this.selectedBandeiras = bandeira;

  }

  ngOnInit(): void {
    this.usuarioLogado = this.auth.jwtPayload?.name;
    this.pesquisarBandeira();
  }

  pesquisar() {
    this.mostraCard = true;

  }

  pesquisarBandeira() {
    this.banderiaService.pesquisarTodas()
      .then(dados => {
        this.bandeiras = dados;
      });
  }
}
