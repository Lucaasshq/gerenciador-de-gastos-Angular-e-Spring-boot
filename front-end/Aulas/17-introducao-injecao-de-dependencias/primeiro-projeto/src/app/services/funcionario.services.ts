export class FuncionarioService {
  funcionarios = [{id: 1, nome: 'joão'}];
  ultimoId = 1;
  adicionar(nome:string){
    const funcionario = {
      id: ++this.ultimoId,
      nome: nome
    };

    this.funcionarios.push(funcionario);
    console.log(this.funcionarios);
  }

  consultar(){
    return this.funcionarios;
  }
}
