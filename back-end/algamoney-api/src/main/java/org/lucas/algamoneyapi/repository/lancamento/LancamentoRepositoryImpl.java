package org.lucas.algamoneyapi.repository.lancamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.repository.filter.LancamentoFilter;

import java.util.List;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Lancamento> filtrar(LancamentoFilter lan) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteriaQuery = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteriaQuery.from(Lancamento.class);

//        Predicate[] predicates = criarRestricoes(lan ,builder, root);
//        criteriaQuery.where(predicates);

        TypedQuery<Lancamento> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }
//
//    private Predicate[] criarRestricoes(LancamentoFilter lancamentoFilter ,CriteriaBuilder builder, Root<Lancamento> root) {
//    }
}
