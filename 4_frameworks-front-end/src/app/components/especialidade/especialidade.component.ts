import { Component, OnInit } from '@angular/core';
import { Especialidade } from 'src/app/model/especialidade';
import { EspecialidadeService } from 'src/app/service/especialidade.service';

@Component({
  selector: 'app-especialidade',
  templateUrl: './especialidade.component.html',
  styleUrls: ['./especialidade.component.css'],
})
export class EspecialidadeComponent implements OnInit {
  constructor(private servicoEspecialidade: EspecialidadeService) {}
  especialidades: Especialidade[] = Array<Especialidade>();

  ngOnInit(): void {
    this.get();
  }
  get(): void {
    this.servicoEspecialidade.get().subscribe((especialidade) => {
      this.especialidades = especialidade;
    });
  }
  delete(id: number): void {
    if (confirm('Deseja realmente cancelar o agendamento?')) {
      this.servicoEspecialidade.delete(id).subscribe({
        complete: () => {
          this.get();
        },
      });
    }
  }
}

