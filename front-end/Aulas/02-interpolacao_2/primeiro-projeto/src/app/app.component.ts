import { Component } from '@angular/core';




@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  nome = 'Jonas'

  add(event:Event) {
    event.preventDefault()
    console.log(`Adicionado ${this.nome}`)

    const numero = Math.round(Math.random() * 100);
    this.nome = 'Lucas ' + numero; 
  }

  alterarNome(event:Event) {
    console.log(event)
    const inputElemnt = event.target as HTMLInputElement
    this.nome = inputElemnt.value
  }
}

