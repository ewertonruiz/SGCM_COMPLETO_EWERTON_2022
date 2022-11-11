import { Component, OnInit } from '@angular/core';
import { Unidade } from 'src/app/model/unidade';
import { UnidadeService } from 'src/app/service/unidade.service';

@Component({
  selector: 'app-unidades',
  templateUrl: './unidades.component.html',
  styleUrls: ['./unidades.component.css'],
})
export class UnidadesComponent implements OnInit {
  constructor(private servicoUnidade: UnidadeService) {}

  ngOnInit(): void {
    this.get();
  }
  unidades: Unidade[] = Array<Unidade>();
  get(): void {
    this.servicoUnidade.get().subscribe((unidade) => {
      this.unidades = unidade;
    });
  }
  delete(id: number): void {
    if (confirm('Deseja realmente excluir a unidade?')) {
      this.servicoUnidade.delete(id).subscribe({
        complete: () => {
          this.get();
        },
      });
    }
  }
}
