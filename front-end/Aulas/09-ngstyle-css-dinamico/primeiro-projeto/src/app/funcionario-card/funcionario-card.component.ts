import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-funcionario-card',
  imports: [CommonModule],
  templateUrl: './funcionario-card.component.html',
  // styleUrl: './funcionario-card.component.css',
  styles: [
    `
      .card-title {
        text-transform: uppercase;
        color: blue;
      }
    `,
  ],
})
export class FuncionarioCardComponent {
  @Input() funcionario: any;

  getEstilosCartao() {
    return {
      'border-width.px': this.funcionario.id,
      'background-color': this.funcionario.id % 2 === 0 ? 'lightblue' : 'lightgreen' ,
    };
  }
}
