import { CommonModule } from '@angular/common';
import { Component, input, OnInit } from '@angular/core';
import { FuncionarioCardComponent } from "./funcionario-card/funcionario-card.component";
import { FuncionarioFormComponent } from "./funcionario-form/funcionario-form.component";
import { FuncionarioService } from './services/funcionario.service';

@Component({
  selector: 'app-root',
  imports: [CommonModule, FuncionarioCardComponent, FuncionarioFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  funcionarios: any = [];



  constructor(private funcionarioService:FuncionarioService ){

  }

  ngOnInit(): void {
     this.funcionarios = this.funcionarioService.consultar()
  }
}
