import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Profissional } from '../model/profissional';
import { ICrudService } from './i-crud-service';

@Injectable({
  providedIn: 'root'
})
export class ProfissionalService implements ICrudService<Profissional> {

  constructor(private http: HttpClient) { }

  apiUrl: string = environment.API_URL + '/profissional/';

  get(termoBusca?: string | undefined): Observable<Profissional[]> {
    let url = this.apiUrl;
    if (termoBusca) {
      url += 'busca/' + termoBusca;
    }
    return this.http.get<Profissional[]>(url);
  }

  getById(id: number): Observable<Profissional> {
    throw new Error('Method not implemented.');
  }

  insert(objeto: Profissional): Observable<Profissional> {
    throw new Error('Method not implemented.');
  }

  update(objeto: Profissional): Observable<Profissional> {
    throw new Error('Method not implemented.');
  }

  delete(id: number): Observable<void> {
    throw new Error('Method not implemented.');
  }

}
