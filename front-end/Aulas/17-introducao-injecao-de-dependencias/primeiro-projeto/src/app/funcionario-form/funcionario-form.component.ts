import { LogService } from '../services/log.service';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FuncionarioService } from '../services/funcionario.service';

@Component({
  selector: 'app-funcionario-form',
  imports: [FormsModule, CommonModule],
  templateUrl: './funcionario-form.component.html',
  styleUrl: './funcionario-form.component.css'
})
export class FuncionarioFormComponent {

  constructor(
    private funcionarioService:FuncionarioService) {

  }
  adicionar(nome:string):void{
    this.funcionarioService.adicionar(nome)

  }
}
