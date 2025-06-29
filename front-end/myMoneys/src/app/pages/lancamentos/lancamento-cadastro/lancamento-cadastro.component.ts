
import { CommonModule } from '@angular/common';
import { TextareaModule  } from 'primeng/textarea';
import { Component } from '@angular/core';
import { ButtonModule } from 'primeng/button';
import { FluidModule } from 'primeng/fluid';
import { InputTextModule } from 'primeng/inputtext';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NovoLancamento } from '../../../Model/NovoLancamento';
import { InputNumberModule } from 'primeng/inputnumber';
import { SelectButtonModule } from 'primeng/selectbutton';
import { Opcao } from '../../../Model/opcoes';
import { DatePickerModule } from 'primeng/datepicker';
import { SelectModule } from 'primeng/select';
import { MessagesModule } from 'primeng/messages';
import { Message } from '../../../Model/messages';
import { MessageComponent } from "../../../shared/message/message.component";




@Component({
  selector: 'app-lancamento-cadastro',
  imports: [FormsModule, InputTextModule, ButtonModule, FluidModule, CommonModule, TextareaModule, RouterModule, DatePickerModule, InputNumberModule, SelectButtonModule, SelectModule, MessagesModule, MessageComponent],
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

    categoriaSelecionada: number | null = null;
    categorias = [
      {label: 'Alimentação', value: 1},
      {label: 'Transporte', value: 2}
    ]

    pessoaSelecionada:string | null = null
    pessoas = [
      {label: 'Lucas', value: 1},
      {label: 'Hannah', value: 5},
      {label: 'João', value: 2}
    ]

    erroLenght: Message[] = [{ severity: 'error', detail: 'Mínimo de 5 caracteres' }];
    erroValue: Message[] = [{severity: 'error', detail: 'Digite um valor minimo R$0,05' }]

}
