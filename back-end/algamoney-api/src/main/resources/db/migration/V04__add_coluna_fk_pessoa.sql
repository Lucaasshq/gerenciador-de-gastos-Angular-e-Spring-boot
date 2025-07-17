ALTER TABLE lancamento
ADD COLUMN codigo_pessoa BIGINT NOT NULL;

ALTER TABLE lancamento
ADD CONSTRAINT fk_lancamento_pessoa
FOREIGN KEY (codigo_pessoa)
REFERENCES pessoa(id);
