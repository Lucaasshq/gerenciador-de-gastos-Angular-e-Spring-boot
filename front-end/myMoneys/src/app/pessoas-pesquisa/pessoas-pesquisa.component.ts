import { Component } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { FluidModule } from 'primeng/fluid';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { TooltipModule } from 'primeng/tooltip';
import { Pessoa } from '../Model/pessoas';

@Component({
  selector: 'app-pessoas-pesquisa',
  imports: [
    CommonModule,
    InputTextModule,
    FluidModule,
    ButtonModule,
    TableModule,
    TooltipModule,
  ],
  templateUrl: './pessoas-pesquisa.component.html',
  styleUrl: './pessoas-pesquisa.component.css',
})
export class PessoasPesquisaComponent {
  pessoas: Pessoa[] = [
    { nome: 'Lucas', cidade: 'Uberlândia', estado: 'MG', status: 'Ativo' },
    { nome: 'Mariana', cidade: 'São Paulo', estado: 'SP', status: 'Inativo' },
    { nome: 'João', cidade: 'Belo Horizonte', estado: 'MG', status: 'Ativo' },
    { nome: 'Fernanda', cidade: 'Curitiba', estado: 'PR', status: 'Ativo' },
    { nome: 'Carlos', cidade: 'Rio de Janeiro', estado: 'RJ', status: 'Inativo' },
    { nome: 'Ana', cidade: 'Salvador', estado: 'BA', status: 'Ativo' },
    { nome: 'Ricardo', cidade: 'Florianópolis', estado: 'SC', status: 'Ativo' },
    { nome: 'Beatriz', cidade: 'Fortaleza', estado: 'CE', status: 'Inativo' },
    { nome: 'Eduardo', cidade: 'Porto Alegre', estado: 'RS', status: 'Ativo' },
    { nome: 'Camila', cidade: 'Brasília', estado: 'DF', status: 'Inativo' }
  ];
}
