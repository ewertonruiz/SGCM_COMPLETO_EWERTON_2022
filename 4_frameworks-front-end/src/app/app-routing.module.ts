import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgendaFormComponent } from './components/agenda-form/agenda-form.component';
import { AgendaListComponent } from './components/agenda-list/agenda-list.component';
import { AtendimentoListComponent } from './components/atendimento-list/atendimento-list.component';
import { ConveniosComponent } from './components/convenios/convenios.component';
import { EspecialidadeComponent } from './components/especialidade/especialidade.component';
import { LoginComponent } from './components/login/login.component';
import { PacientesComponent } from './components/pacientes/pacientes.component';
import { ProfissionaisComponent } from './components/profissionais/profissionais.component';
import { UnidadesComponent } from './components/unidades/unidades.component';
// import { UsuarioComponent } from './components/usuario/usuario.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { AutenticacaoGuard } from './service/autenticacao.guard';

const routes: Routes = [
  {
    path: '',
    canActivate: [AutenticacaoGuard],
    children: [
      { path: 'agenda', component: AgendaListComponent },
      { path: 'agenda/form', component: AgendaFormComponent },
      { path: 'atendimento', component: AtendimentoListComponent },
      { path: 'especialidades', component: EspecialidadeComponent },
      { path: 'pacientes', component: PacientesComponent },
      { path: 'convenios', component: ConveniosComponent },
      { path: 'unidades', component: UnidadesComponent },
      { path: 'usuarios', component: UsuariosComponent },
      { path: 'profissionais', component: ProfissionaisComponent },

      {
        path: 'config',
        canActivate: [AutenticacaoGuard],
        data: { papel: 'ROLE_ADMIN' },
        children: [{ path: 'usuarios', component: UsuariosComponent }],
      },
    ],
  },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
