-- Remove a foreign key errada (se foi criada)
ALTER TABLE lancamento
DROP CONSTRAINT IF EXISTS fk_lancamento_pessoa;

-- Corrige o nome da coluna se necessário (pessoa -> pessoas)
-- (pule essa parte se a coluna já estiver correta)
-- ALTER TABLE lancamento RENAME COLUMN codigo_pessoa TO codigo_pessoas;

-- Adiciona a constraint correta para a tabela 'pessoas'
ALTER TABLE lancamento
ADD CONSTRAINT fk_lancamento_pessoas
FOREIGN KEY (codigo_pessoa)
REFERENCES pessoas(id);
