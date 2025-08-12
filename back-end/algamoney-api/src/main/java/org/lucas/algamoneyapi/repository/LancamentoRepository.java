package org.lucas.algamoneyapi.repository;

import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.repository.lancamento.LancamentoRepositoryQuery;
import org.lucas.algamoneyapi.repository.projection.LancamentoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

    @Query("""
        SELECT l.id AS id,
               l.descricao AS descricao,
               l.dataVencimento AS dataVencimento,
               l.dataPagamento AS dataPagamento,
               l.valor AS valor,
               l.tipo AS tipo,
               c.nome AS categoria,
               p.nome AS pessoa
        FROM Lancamento l
        JOIN l.categoria c
        JOIN l.pessoa p
    """)
    Page<LancamentoProjection> lancamentoProjection(Pageable pageable);
}
