import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';




@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  nome:string = 'Lucas';
  idade:number = 21

  getIdade() {
    return this.idade
  }
}
