import { CommonModule } from '@angular/common';
import { Component, input } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [FormsModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  ultimoId = 0
  nome: string = '';
  adicionado: boolean = false;
  funcionarios: any[] = [];


  add() {
    console.log(`Adicionado ${this.nome}`)
    this.adicionado = true
    this.funcionarios.push({
      nome: this.nome,
      id: ++this.ultimoId
    })
  }
}
