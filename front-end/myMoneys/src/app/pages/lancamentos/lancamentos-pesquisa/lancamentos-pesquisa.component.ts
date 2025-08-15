import { Component, Output } from '@angular/core';
import { InputTextModule } from 'primeng/inputtext';
import { FluidModule } from 'primeng/fluid';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { CommonModule } from '@angular/common';
import { TooltipModule } from 'primeng/tooltip';
import { RouterModule } from '@angular/router';
import { LancamentoService } from './lancamento.service';
import { FormsModule } from '@angular/forms';
import { LancamentosGridComponent } from "../../../layouts/lancamentos-grid/lancamentos-grid.component";

@Component({
  selector: 'app-lancamentos-pesquisa',
  imports: [
    CommonModule,
    InputTextModule,
    FormsModule,
    FluidModule,
    ButtonModule,
    TableModule,
    TooltipModule,
    RouterModule,
    LancamentosGridComponent
],
  templateUrl: './lancamentos-pesquisa.component.html',
  styleUrl: './lancamentos-pesquisa.component.css',
})
export class LancamentosPesquisaComponent  {

  constructor(private lancamentoService: LancamentoService){}
  descricao: string = "";

    pesquisar(){
      this.lancamentoService.pesquisar({descricao: this.descricao}).subscribe({
        next: data => {
          this.lancamentos = data.content;
          console.log((this.lancamentos));
        }
      })
    }

    lancamentos = [];
    
    

}
