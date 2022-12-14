import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Unidade } from 'src/app/model/unidade';
import { AlertaService } from 'src/app/service/alerta.service';
import { UnidadeService } from 'src/app/service/unidade.service';
import { Utils } from 'src/app/utils/utils';

@Component({
  selector: 'app-unidade-form',
  templateUrl: './unidade-form.component.html',
  styles: [
  ]
})
export class UnidadeFormComponent implements OnInit {

  constructor(
    private servico: UnidadeService,
    private route: ActivatedRoute,
    private router: Router,
    private servicoAlerta: AlertaService
  ) { }

  registro: Unidade = <Unidade>{};
  compareById = Utils.compareById;

  submit(form: NgForm): void {

    if (this.registro.id) {
      this.servico.update(this.registro).subscribe({
        complete: () => {
          this.router.navigate(['/config/unidade']);
          this.servicoAlerta.enviarAlertaSucesso();
        }
      });
    } else {
      this.servico.insert(this.registro).subscribe({
        complete: () => {
          form.resetForm();
          this.servicoAlerta.enviarAlertaSucesso();
        } 
      });
    }

  }

  ngOnInit(): void {
    const id = this.route.snapshot.queryParamMap.get("id");
    if (id) {
      this.servico.getById(+id).subscribe({
        next: (resposta: Unidade) => {
          this.registro = resposta;
        }
      })
    }
  }

}
