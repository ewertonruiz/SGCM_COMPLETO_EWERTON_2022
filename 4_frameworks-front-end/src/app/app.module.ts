import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AgendaListComponent } from './components/agenda-list/agenda-list.component';
import { AgendaFormComponent } from './components/agenda-form/agenda-form.component';
import { AtendimentoListComponent } from './components/atendimento-list/atendimento-list.component';
import { BarraComandosComponent } from './components/barra-comandos/barra-comandos.component';
import { AlertaComponent } from './components/alerta/alerta.component';
import { ErroInterceptor } from './interceptors/erro.interceptor';
import { LoginComponent } from './components/login/login.component';
import { RequisicaoInterceptor } from './interceptors/requisicao.interceptor';
// import { UsuarioComponent } from './components/usuario/usuario.component';
import { EspecialidadeComponent } from './components/especialidade/especialidade.component';
import { PacientesComponent } from './components/pacientes/pacientes.component';
import { ConveniosComponent } from './components/convenios/convenios.component';
import { UnidadesComponent } from './components/unidades/unidades.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { ProfissionaisComponent } from './components/profissionais/profissionais.component';

@NgModule({
  declarations: [
    AppComponent,
    AgendaListComponent,
    AgendaFormComponent,
    AtendimentoListComponent,
    BarraComandosComponent,
    AlertaComponent,
    LoginComponent,
    // UsuarioComponent,
    EspecialidadeComponent,
    PacientesComponent,
    ConveniosComponent,
    UnidadesComponent,
    UsuariosComponent,
    ProfissionaisComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: ErroInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: RequisicaoInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
