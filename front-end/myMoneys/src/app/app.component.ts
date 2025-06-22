import { Component } from '@angular/core';

import { MessageService } from 'primeng/api';
import { LancamentoCadastroComponent } from './pages/lancamentos/lancamento-cadastro/lancamento-cadastro.component';
import { LancamentosPesquisaComponent } from './pages/lancamentos/lancamentos-pesquisa/lancamentos-pesquisa.component';
import { NavBarComponent } from "./layouts/nav-bar/nav-bar.component";
import { RouterOutlet } from '@angular/router';
import { PessoasPesquisaComponent } from "./pages/pessoas/pessoas-pesquisa/pessoas-pesquisa.component";

@Component({
  selector: 'app-root',
  imports: [
    NavBarComponent,
    RouterOutlet
],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [MessageService],
})
export class AppComponent {

}
