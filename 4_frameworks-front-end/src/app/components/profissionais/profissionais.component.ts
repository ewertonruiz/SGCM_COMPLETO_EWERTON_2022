import { Component, OnInit } from '@angular/core';
import { Profissional } from 'src/app/model/profissional';
import { ProfissionalService } from 'src/app/service/profissional.service';

@Component({
  selector: 'app-profissionais',
  templateUrl: './profissionais.component.html',
  styleUrls: ['./profissionais.component.css'],
})
export class ProfissionaisComponent implements OnInit {
  constructor(private servicoProfissional: ProfissionalService) {}

  ngOnInit(): void {
    this.get();
  }
  profissionais: Profissional[] = Array<Profissional>();
  get(): void {
    this.servicoProfissional.get().subscribe((profissional) => {
      this.profissionais = profissional;
    });
  }
  delete(id: number): void {
    if (confirm('Deseja realmente excluir este profissional?')) {
      this.servicoProfissional.delete(id).subscribe({
        complete: () => {
          this.get();
        },
      });
    }
  }
}
