export interface Lancamento {
  tipo: 'DESPESA' | 'RECEITA',
  descricao:string,
  dataVencimento: Date,
  dataPagamento: Date | null,
  valor: number,
  pessoa: string;
}
