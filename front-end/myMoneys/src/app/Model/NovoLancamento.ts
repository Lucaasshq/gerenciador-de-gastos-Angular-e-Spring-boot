export interface NovoLancamento {
  vencimento: Date;
  recebimento: Date;
  descricao: string;
  valor: number;
  categoria: string;
  pessoa: string;
  observacao: string;
}
