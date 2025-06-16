import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Cliente } from '../model/Cliente';

@Component({
  selector: 'app-root',
  imports: [FormsModule, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  cliente1: Cliente = new Cliente();

  profissoes: String[] = ['Desenvolvedor', 'Empresário', 'Outra'];
  salvar(form: NgForm): void {
    // this.cliente1.nome = form.value.nome;
    // this.cliente1.email = form.value.email;
    // this.cliente1.profissao = form.value.profissao;

    // console.log(this.cliente1.nome);
    // console.log(this.cliente1.email);
    // console.log(this.cliente1.profissao);
    console.log(form);
    console.log(form.valid);
  }
}
