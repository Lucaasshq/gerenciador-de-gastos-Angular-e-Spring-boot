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
  ultimoId = 0
  nome: string = '';
  adicionado: boolean = false;
 @Output() funcionarioAdicionado = new EventEmitter();


  add() {
    this.adicionado = true

   const funcionario = {
      nome: this.nome,
      id: ++this.ultimoId
    };
    this.funcionarioAdicionado.emit(funcionario)
  }
}
