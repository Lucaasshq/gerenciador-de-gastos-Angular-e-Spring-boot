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
  nome:string = '';
  adicionado:boolean = false;

  add() {
    console.log(`Adicionado ${this.nome}`)
    this.adicionado = true
  }
}
