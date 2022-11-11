import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Especialidade } from '../model/especialidade';
import { ICrudService } from './i-crud-service';

@Injectable({
  providedIn: 'root',
})
export class EspecialidadeService implements ICrudService<Especialidade> {
  constructor(private http: HttpClient) {}
  apiUrl: string = environment.API_URL + '/config/especialidade/';

  get(termoBusca?: string | undefined): Observable<Especialidade[]> {
    let url = this.apiUrl;
    if (termoBusca) {
      url += 'busca/' + termoBusca;
    }
    return this.http.get<Especialidade[]>(url);
  }

  getById(id: number): Observable<Especialidade> {
    throw new Error('Method not implemented.');
  }

  insert(objeto: Especialidade): Observable<Especialidade> {
    throw new Error('Method not implemented.');
  }

  update(objeto: Especialidade): Observable<Especialidade> {
    throw new Error('Method not implemented.');
  }

  delete(id: number): Observable<void> {
    throw new Error('Method not implemented.');
  }
}
