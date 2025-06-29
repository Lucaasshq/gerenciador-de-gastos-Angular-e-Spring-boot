import { Injectable } from '@angular/core';

import { LogService } from './log.service';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  private funcionarios: {id: number, nome:string}[] = [{id: 1, nome: 'joão'}];
  private ultimoId:number = 1;

  constructor(private logService:LogService){}

  adicionar(nome:string): void{
    this.logService.log(`Adicionando ${nome}`)
    const funcionario = {
      id: ++this.ultimoId,
      nome: nome
    };
    this.funcionarios.push(funcionario);
    console.log(this.funcionarios);
  }

  consultar(): {id: number, nome:string}[] {
    return this.funcionarios;
  }
}
