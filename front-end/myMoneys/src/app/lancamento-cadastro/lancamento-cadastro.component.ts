import { TextareaModule  } from 'primeng/textarea';
import { Component } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { FluidModule } from 'primeng/fluid';
import { InputTextModule } from 'primeng/inputtext';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-lancamento-cadastro',
  imports: [InputTextModule, ButtonModule, FluidModule, TextareaModule, RouterModule],
  templateUrl: './lancamento-cadastro.component.html',
  styleUrl: './lancamento-cadastro.component.css'
})
export class LancamentoCadastroComponent {

}
