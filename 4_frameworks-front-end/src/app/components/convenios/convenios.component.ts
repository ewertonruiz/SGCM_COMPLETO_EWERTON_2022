import { Component, OnInit } from '@angular/core';
import { Convenio } from 'src/app/model/convenio';
import { ConvenioService } from 'src/app/service/convenio.service';

@Component({
  selector: 'app-convenios',
  templateUrl: './convenios.component.html',
  styleUrls: ['./convenios.component.css'],
})
export class ConveniosComponent implements OnInit {
  constructor(private service: ConvenioService) {}

  ngOnInit(): void {
    this.get();
  }
  convenios: Convenio[] = Array<Convenio>();
  get(): void {
    this.service.get().subscribe((convenio) => {
      this.convenios = convenio;
    });
  }
  delete(id: number): void {
    if (confirm('Deseja realmente excluir o convenio ?')) {
      this.service.delete(id).subscribe({
        complete: () => {
          this.get();
        },
      });
    }
  }
}
