package org.lucas.algamoneyapi.repository;

import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}
