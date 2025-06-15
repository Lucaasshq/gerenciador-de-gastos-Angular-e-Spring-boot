import { Component } from '@angular/core';

import { MessageService } from 'primeng/api';

import { LancamentosPesquisaComponent } from './lancamentos-pesquisa/lancamentos-pesquisa.component';
import { NavBarComponent } from "./nav-bar/nav-bar.component";
import { RouterOutlet } from '@angular/router';
import { PessoasPesquisaComponent } from "./pessoas-pesquisa/pessoas-pesquisa.component";

@Component({
  selector: 'app-root',
  imports: [
    NavBarComponent,
    RouterOutlet,
],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [MessageService],
})
export class AppComponent {

}
