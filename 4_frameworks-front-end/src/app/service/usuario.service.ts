import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  constructor(private http: HttpClient) {}
  apiUrl: string = environment.API_URL + '/config/usuario/';

  get(termoBusca?: string | undefined): Observable<Usuario[]> {
    let url = this.apiUrl;
    if (termoBusca) {
      url += 'busca/' + termoBusca;
    }
    return this.http.get<Usuario[]>(url);
  }

  getById(id: number): Observable<Usuario> {
    throw new Error('Method not implemented.');
  }

  insert(objeto: Usuario): Observable<Usuario> {
    throw new Error('Method not implemented.');
  }

  update(objeto: Usuario): Observable<Usuario> {
    throw new Error('Method not implemented.');
  }

  delete(id: number): Observable<void> {
    throw new Error('Method not implemented.');
  }
}
