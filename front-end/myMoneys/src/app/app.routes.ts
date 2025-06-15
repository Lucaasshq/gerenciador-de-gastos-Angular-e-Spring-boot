import { LancamentosPesquisaComponent } from './lancamentos-pesquisa/lancamentos-pesquisa.component';
import { PessoasPesquisaComponent } from './pessoas-pesquisa/pessoas-pesquisa.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'lancamentos-pesquisa', pathMatch: 'full' },
  { path: 'lancamentos-pesquisa', component: LancamentosPesquisaComponent },
  { path: 'pessoas-pesquisa', component: PessoasPesquisaComponent },
];
