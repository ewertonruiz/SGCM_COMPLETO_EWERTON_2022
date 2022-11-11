import { Component, OnInit } from '@angular/core';
import { Unidade } from 'src/app/model/unidade';
import { UnidadeService } from 'src/app/service/unidade.service';
import { IList } from '../i-list';

@Component({
  selector: 'app-unidade-list',
  templateUrl: './unidade-list.component.html',
  styles: [
  ]
})
export class UnidadeListComponent implements OnInit, IList<Unidade> {

  constructor(
    private servico: UnidadeService
  ) { }
  registros: Unidade[] = Array<Unidade>();
  get(termoBusca?: string | undefined): void {
    this.servico.get(termoBusca).subscribe({
      next: (resposta: Unidade[]) => {
        this.registros = resposta.sort(
          (a, b) => a.nome.localeCompare(b.nome)
        );
      }
    })
  }
  delete(id: number): void {
    if (confirm('Deseja realmente cancelar o agendamento?')) {
      this.servico.delete(id).subscribe({
        complete: () => {
          this.get();
        }
      })
    }
  }

  ngOnInit(): void {
    this.get();
  }

}
