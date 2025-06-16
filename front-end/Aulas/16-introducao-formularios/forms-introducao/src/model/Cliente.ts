export class Cliente {
  nome?: string;
  email?: string;
  profissao?: string;
  constructor(nome?: string, email?: string, profissao?: string) {
    this.nome = nome;
    this.email = email;
    this.profissao = profissao;
  }
}
