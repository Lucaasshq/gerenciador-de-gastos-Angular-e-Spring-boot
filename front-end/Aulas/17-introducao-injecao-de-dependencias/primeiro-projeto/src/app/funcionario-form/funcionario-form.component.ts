import { FuncionarioService } from './../services/funcionario.services';
import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-funcionario-form',
  imports: [FormsModule, CommonModule],
  templateUrl: './funcionario-form.component.html',
  styleUrl: './funcionario-form.component.css'
})
export class FuncionarioFormComponent {
  funcionarioService:FuncionarioService;

  constructor() {
    this.funcionarioService = new FuncionarioService();
  }
  adicionar(nome:string){
    this.funcionarioService.adicionar(nome)

  }
}
