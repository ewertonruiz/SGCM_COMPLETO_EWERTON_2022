import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css'],
})
export class UsuariosComponent implements OnInit {
  constructor(private servicoUsuario: UsuarioService) {}

  ngOnInit(): void {
    this.get()
  }
  usuarios: Usuario[] = Array<Usuario>();
  get(): void {
    this.servicoUsuario.get().subscribe((usuario => {this.usuarios = usuario}))
  }
  delete(id: number): void {
    if (confirm('Deseja realmente excluir o usuario?')) {
      this.servicoUsuario.delete(id).subscribe({
        complete: () => {
          this.get();
        },
      });
    }
  }
}
