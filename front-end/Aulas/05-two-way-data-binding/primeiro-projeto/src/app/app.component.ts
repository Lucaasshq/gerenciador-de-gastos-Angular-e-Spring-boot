import { Component, input } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  nome:string = '';

  add(event: Event, nomeInput: any) {
    event.preventDefault();
    this.nome = nomeInput
    console.log(this.nome)
    
  }
}
