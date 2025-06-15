import { Component, Input } from '@angular/core';


@Component({
  selector: 'app-funcionario-card',
  imports: [],
  templateUrl: './funcionario-card.component.html',
  styleUrl: './funcionario-card.component.css',
})
export class FuncionarioCardComponent {
  @Input() funcionario: any
}
