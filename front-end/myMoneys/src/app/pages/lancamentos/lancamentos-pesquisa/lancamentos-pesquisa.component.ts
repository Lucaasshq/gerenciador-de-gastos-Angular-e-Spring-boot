import { Component } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { FluidModule } from 'primeng/fluid';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { Lancamento } from '../../../Model/Lancamentos';
import { CommonModule } from '@angular/common';
import { TooltipModule } from 'primeng/tooltip';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-lancamentos-pesquisa',
  imports: [
    CommonModule,
    InputTextModule,
    FluidModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    RouterModule
  ],
  templateUrl: './lancamentos-pesquisa.component.html',
  styleUrl: './lancamentos-pesquisa.component.css',
})
export class LancamentosPesquisaComponent {
  lancamentos: Lancamento[] = [
    {
      tipo: 'DESPESA',
      descricao: 'Compra de pão',
      dataVencimento: new Date(2017, 5, 30),
      dataPagamento: null,
      valor: 5,
      pessoa: 'Padaria do José',
    },
    {
      tipo: 'DESPESA',
      descricao: 'Compra de leite',
      dataVencimento: new Date(2017, 6, 1),
      dataPagamento: null,
      valor: 4.55,
      pessoa: 'Supermercado da Dona Maria',
    },
    {
      tipo: 'RECEITA',
      descricao: 'Venda de pão',
      dataVencimento: new Date(2017, 6, 5),
      dataPagamento: new Date(2017, 6, 6),
      valor: 10,
      pessoa: 'Cliente A',
    },
    {
      tipo: 'DESPESA',
      descricao: 'Compra de café',
      dataVencimento: new Date(2017, 6, 7),
      dataPagamento: new Date(2017, 6, 8),
      valor: 7.5,
      pessoa: 'Café & Companhia',
    },
    {
      tipo: 'RECEITA',
      descricao: 'Venda de café',
      dataVencimento: new Date(2017, 6, 10),
      dataPagamento: new Date(2017, 6, 11),
      valor: 15,
      pessoa: 'Cliente B',
    },
    {
      tipo: 'DESPESA',
      descricao: 'Compra de frutas',
      dataVencimento: new Date(2017, 6, 15),
      dataPagamento: null,
      valor: 12.25,
      pessoa: 'Feira da Praça',
    },
    {
      tipo: 'RECEITA',
      descricao: 'Venda de frutas',
      dataVencimento: new Date(2017, 6, 16),
      dataPagamento: new Date(2017, 6, 17),
      valor: 18.3,
      pessoa: 'Cliente C',
    },
    {
      tipo: 'DESPESA',
      descricao: 'Aluguel do mês',
      dataVencimento: new Date(2017, 6, 30),
      dataPagamento: new Date(2017, 6, 31),
      valor: 500,
      pessoa: 'Imobiliária XYZ',
    },
    {
      tipo: 'RECEITA',
      descricao: 'Venda de equipamento',
      dataVencimento: new Date(2017, 7, 5),
      dataPagamento: new Date(2017, 7, 6),
      valor: 250,
      pessoa: 'Cliente D',
    },
    {
      tipo: 'DESPESA',
      descricao: 'Manutenção do computador',
      dataVencimento: new Date(2017, 7, 10),
      dataPagamento: new Date(2017, 7, 11),
      valor: 75,
      pessoa: 'Assistência Técnica A',
    },
  ];
}
