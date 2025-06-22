
import { CommonModule } from '@angular/common';
import { TextareaModule  } from 'primeng/textarea';
import { Component } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { FluidModule } from 'primeng/fluid';
import { InputTextModule } from 'primeng/inputtext';
import { RouterModule, RouterOutlet } from '@angular/router';
import { FormsModule, NgModel } from '@angular/forms';
import { NovoLancamento } from '../../../Model/NovoLancamento';
import { InputNumberModule } from 'primeng/inputnumber';
import { SelectButtonModule } from 'primeng/selectbutton';
import { Opcao } from '../../../Model/opcoes';
import { DropdownModule } from 'primeng/dropdown';
import { DatePickerModule } from 'primeng/datepicker';



@Component({
  selector: 'app-lancamento-cadastro',
  imports: [FormsModule ,InputTextModule, ButtonModule, FluidModule, CommonModule, TextareaModule, RouterModule, DatePickerModule, InputNumberModule, SelectButtonModule, DropdownModule],
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

  opcoes: Opcao[] = [
     {label: 'Receita', value: 'Receita'},
     {label: 'Despesa', value: 'Despesa'}
    ];

    value: string = 'Receita';

    categorias = [
      {label: 'Alimentação', value: 1},
      {label: 'Transporte', value: 2}
    ]

    pessoas = [
      {label: 'Lucas', value: 1},
      {label: 'Hannah', value: 5},
      {label: 'João', value: 2}
    ]


}
