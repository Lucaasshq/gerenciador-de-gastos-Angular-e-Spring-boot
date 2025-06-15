import { CommonModule } from '@angular/common';
import { Component, input } from '@angular/core';
import { FuncionarioCardComponent } from "./funcionario-card/funcionario-card.component";
import { FuncionarioFormComponent } from "./funcionario-form/funcionario-form.component";

@Component({
  selector: 'app-root',
  imports: [CommonModule, FuncionarioCardComponent, FuncionarioFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  funcionarios: any[] = [];

  aoAdicionar(funcionario: any) {
    this.funcionarios.push(funcionario);
  }
}
