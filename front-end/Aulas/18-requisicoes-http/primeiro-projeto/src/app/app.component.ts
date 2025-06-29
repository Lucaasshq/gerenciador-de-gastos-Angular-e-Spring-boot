import { CommonModule } from '@angular/common';
import { Component, input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  cidades: any[] = [
    
  ]

  adicionar(nome:string):void{
    alert(nome);
  }
  remover(id:number){
    alert(id);
  }

  atualizar(cidade: any){
    alert(JSON.stringify(cidade));
  }





}
