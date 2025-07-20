package org.lucas.algamoneyapi.repository.lancamento;

import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public  List<Lancamento> filtrar(LancamentoFilter lan);
}
