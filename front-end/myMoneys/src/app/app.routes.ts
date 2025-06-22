import { LancamentoCadastroComponent } from './pages/lancamentos/lancamento-cadastro/lancamento-cadastro.component';
import { LancamentosPesquisaComponent } from './pages/lancamentos/lancamentos-pesquisa/lancamentos-pesquisa.component';
import { PessoaCadastroComponent } from './pages/pessoas/pessoa-cadastro/pessoa-cadastro.component';
import { PessoasPesquisaComponent } from './pages/pessoas/pessoas-pesquisa/pessoas-pesquisa.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: 'lancamentos-pesquisa', pathMatch: 'full' },
  { path: 'lancamentos-pesquisa', component: LancamentosPesquisaComponent },
  { path: 'pessoas-pesquisa', component: PessoasPesquisaComponent },
  { path: 'lancamento-cadastro', component: LancamentoCadastroComponent },
  { path: 'pessoa-cadastro', component: PessoaCadastroComponent}
];
