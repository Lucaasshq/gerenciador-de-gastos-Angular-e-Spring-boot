import { Component, input } from '@angular/core';

@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  nome = 'Jonas';

  add(event: Event, nomeInput: string) {
    event.preventDefault();
    this.nome = nomeInput;
  }
}
