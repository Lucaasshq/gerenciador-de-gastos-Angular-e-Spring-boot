import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [FormsModule, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  profissoes: String[] = ['Desenvolvedor', 'Empresário', 'Outra'];

  salvar(form: NgForm): void {
    alert('Salvando');
    console.log(form);
    console.log(form.value.nome);
    console.log(form.value.email);
    alert('Profissão salva: ' + form.value.profissao);
  }
}
