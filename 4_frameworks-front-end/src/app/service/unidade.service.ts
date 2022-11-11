import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Unidade } from '../model/unidade';

@Injectable({
  providedIn: 'root',
})
export class UnidadeService {
  constructor(private http: HttpClient) {}
  apiUrl: string = environment.API_URL + '/config/unidade/';

  get(termoBusca?: string | undefined): Observable<Unidade[]> {
    let url = this.apiUrl;
    if (termoBusca) {
      url += 'busca/' + termoBusca;
    }
    return this.http.get<Unidade[]>(url);
  }

  getById(id: number): Observable<Unidade> {
    throw new Error('Method not implemented.');
  }

  insert(objeto: Unidade): Observable<Unidade> {
    throw new Error('Method not implemented.');
  }

  update(objeto: Unidade): Observable<Unidade> {
    throw new Error('Method not implemented.');
  }

  delete(id: number): Observable<void> {
    throw new Error('Method not implemented.');
  }
}
