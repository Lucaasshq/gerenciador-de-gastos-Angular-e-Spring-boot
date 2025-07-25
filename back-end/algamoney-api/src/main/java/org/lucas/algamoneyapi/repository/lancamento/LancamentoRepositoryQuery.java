package org.lucas.algamoneyapi.repository.lancamento;

import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lan, Pageable pageable);
}
