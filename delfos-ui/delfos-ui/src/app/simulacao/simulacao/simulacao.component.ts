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

  bandeiras: Bandeira[] = [];
  selectedBandeiras: Bandeira | undefined;


  bandeiraSelecionada?: number;
  mensagem: string = '';


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

  }

  ngOnInit(): void {
    this.usuarioLogado = this.auth.jwtPayload?.name;
    this.pesquisarBandeira();
  }

  pesquisar(minutos: string, equipamento: number, bandeira: string) {
    this.mensagem = '';
    this.mostraCard = true;
    let result = equipamento / 1000;

    if (parseInt(bandeira) == 1) {
      this.mensagem = 'O valor da simulação na Bandeira Verde ficou em aproximadamente: R$' + Math.round(((0.59266 * result) / 60) * parseInt(minutos));
    }else if (parseInt(bandeira) == 2) {
      let acrescimo = (result * 0.01874);
      this.mensagem = 'O valor da simulação na Bandeira Amarela ficou em aproximadamente: R$' + Math.round(acrescimo + (((0.59266 * result) / 60) * parseInt(minutos)));
    }else if (parseInt(bandeira) == 3) {
      let acrescimo = (result * 0.03971);
      this.mensagem = 'O valor da simulação na Bandeira Vermelha I ficou em aproximadamente: R$' + Math.round(acrescimo + (((0.59266 * result) / 60) * parseInt(minutos)));
    } else if (parseInt(bandeira) == 4) {
      let acrescimo = (result * 0.09492);
      this.mensagem = 'O valor da simulação na Bandeira Vermelha II ficou em aproximadamente: R$' + Math.round(acrescimo + (((0.59266 * result) / 60) * parseInt(minutos)));
    }

  }

  pesquisarBandeira() {
    this.banderiaService.pesquisarTodas()
      .then((dados: any) => {
        this.bandeiraSelecionada = 1;
        this.bandeiras = dados.bandeira.map((dado: any) => ({ label: dado.type, value: dado.id }));

      });
  }
}
