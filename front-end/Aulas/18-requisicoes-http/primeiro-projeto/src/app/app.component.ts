import { CommonModule, JsonPipe } from '@angular/common';
import { Component, input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CidadeService } from './cidade.service';
import { Cidade } from './cidade';
import { tap } from 'rxjs';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule, ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
   cidades: Cidade[] = []
   novaCidade: Omit<Cidade, 'id'> = { nome: ''}

  constructor(private cidadeService: CidadeService){}

  ngOnInit(): void {
    this.carregar()
  }

  carregar(): void {
    this.cidadeService.consultar().pipe(tap(body => console.log(body))).subscribe({
      next: (dados) => this.cidades = dados,
      error: (err) => console.error("Erro ao carregar cidades", err)
    })
  }


  adicionar(nome: string): void {
  if (!nome.trim()) return;  // evita enviar nome vazio

  this.cidadeService.adicionar({nome: nome}).pipe( tap(res => alert(res.id)) ).subscribe({
    next: (cidadeCriada) => {
      this.cidades.push(cidadeCriada);  // adiciona cidade à lista local
      this.novaCidade = {nome: ''};         // limpa o campo do formulário
    },
    error: (err) => console.error("Erro ao adicionar cidade", err),
  });
}


  remover(id:string): void{

    this.cidadeService.excluir(id).subscribe({
      next: () => this.cidades = this.cidades.filter(c => c.id !== id),
      error: (err) => console.error("Erro ao remover", err)
    })
  }

  atualizar(cidade: Cidade):void{
    this.cidadeService.atualizar(cidade).subscribe( {
      next: () => alert("Cidade atualizada com sucesso"),
      error: (err) => alert("Erro ao atualizar a cidade" + err )
    } )
  }





}
