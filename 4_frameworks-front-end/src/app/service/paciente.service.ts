import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Paciente } from '../model/paciente';
import { ICrudService } from './i-crud-service';

@Injectable({
  providedIn: 'root'
})
export class PacienteService implements ICrudService<Paciente> {

  constructor(
    private http: HttpClient
  ) { }

  apiUrl: string = environment.API_URL + '/paciente/';

  get(termoBusca?: string | undefined): Observable<Paciente[]> {
    let url = this.apiUrl;
    if (termoBusca) {
      url += 'busca/' + termoBusca;
    }
    return this.http.get<Paciente[]>(url);
  }

  getById(id: number): Observable<Paciente> {
    throw new Error('Method not implemented.');
  }

  insert(objeto: Paciente): Observable<Paciente> {
    throw new Error('Method not implemented.');
  }

  update(objeto: Paciente): Observable<Paciente> {
    throw new Error('Method not implemented.');
  }

  delete(id: number): Observable<void> {
    throw new Error('Method not implemented.');
  }
  
}
