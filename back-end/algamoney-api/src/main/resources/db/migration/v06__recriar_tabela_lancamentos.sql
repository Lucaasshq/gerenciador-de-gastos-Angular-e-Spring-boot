DROP TABLE IF EXISTS lancamento CASCADE;

CREATE TABLE lancamento (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(255),
    dataVencimento DATE,
    dataPagamento DATE,
    valor NUMERIC(10, 2),
    observacao TEXT,
    tipo VARCHAR(50) NOT NULL,
    codigo_categoria BIGINT NOT NULL,
    codigo_pessoa BIGINT NOT NULL,

    CONSTRAINT fk_lancamento_categoria FOREIGN KEY (codigo_categoria) REFERENCES categoria(id),
    CONSTRAINT fk_lancamento_pessoa FOREIGN KEY (codigo_pessoa) REFERENCES pessoas(id)
);
