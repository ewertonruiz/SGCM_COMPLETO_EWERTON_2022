import { Component, OnInit } from '@angular/core';
import { Paciente } from 'src/app/model/paciente';
import { PacienteService } from 'src/app/service/paciente.service';

@Component({
  selector: 'app-pacientes',
  templateUrl: './pacientes.component.html',
  styleUrls: ['./pacientes.component.css'],
})
export class PacientesComponent implements OnInit {
  constructor(private service: PacienteService) {}

  ngOnInit(): void {
    this.get();
  }
  pacientes: Paciente[] = Array<Paciente>();
  get(): void {
    this.service.get().subscribe((paciente) => {
      this.pacientes = paciente;
    });
  }
  delete(id: number): void {
    if (confirm('Deseja realmente excluir este paciente ?')) {
      this.service.delete(id).subscribe({
        complete: () => {
          this.get();
        },
      });
    }
  }
}
