
import { CommonModule } from '@angular/common';
import { TextareaModule  } from 'primeng/textarea';
import { Component } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { FluidModule } from 'primeng/fluid';
import { InputTextModule } from 'primeng/inputtext';
import { RouterModule, RouterOutlet } from '@angular/router';
import { CalendarModule } from 'primeng/calendar';
import { FormsModule } from '@angular/forms';
import { NovoLancamento } from '../../Model/NovoLancamento';
import { InputNumberModule } from 'primeng/inputnumber';





@Component({
  selector: 'app-lancamento-cadastro',
  imports: [FormsModule ,InputTextModule, ButtonModule, FluidModule, CommonModule, TextareaModule, RouterModule, CalendarModule, InputNumberModule],
  templateUrl: './lancamento-cadastro.component.html',
  styleUrl: './lancamento-cadastro.component.css'
})
export class LancamentoCadastroComponent {

  NovoLancamento: NovoLancamento = {
    vencimento: new Date(),
    recebimento: new Date(),
    descricao: '',
    valor: 0.0,
    categoria: '',
    pessoa: '',
    observacao: ''
  }

}
