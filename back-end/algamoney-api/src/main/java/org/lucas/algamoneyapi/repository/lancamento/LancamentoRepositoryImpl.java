package org.lucas.algamoneyapi.repository.lancamento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.flywaydb.core.internal.util.StringUtils;
import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class LancamentoRepositoryImpl implements LancamentoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public Page<Lancamento> filtrar(LancamentoFilter lan, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Lancamento> criteriaQuery = builder.createQuery(Lancamento.class);
        Root<Lancamento> root = criteriaQuery.from(Lancamento.class);

        Predicate[] predicates = criarRestricoes(lan ,builder, root);
        criteriaQuery.where(predicates);

        TypedQuery<Lancamento> query = manager.createQuery(criteriaQuery);
        adicionarRestricoesDePaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, total(lan) );
    }




    private Predicate[] criarRestricoes(LancamentoFilter filtro, CriteriaBuilder builder, Root<Lancamento> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(filtro.getDescricao())) {
            predicates.add(builder.like(
                    builder.lower(root.get("descricao")),
                    "%" + filtro.getDescricao().toLowerCase() + "%"
            ));
        }

        if (filtro.getDataVencimentoDe() != null) {
            predicates.add(builder.greaterThanOrEqualTo(
                    root.get("dataVencimento"), filtro.getDataVencimentoDe()
            ));
        }

        if (filtro.getDataVencimentoAte() != null) {
            predicates.add(builder.lessThanOrEqualTo(
                    root.get("dataVencimento"), filtro.getDataVencimentoAte()
            ));
        }

        return predicates.toArray(new Predicate[0]);
    }
    private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistroPorPagina = pageable.getPageSize();
        int primeiroRegistroPagina = paginaAtual * totalRegistroPorPagina;
        query.setFirstResult(primeiroRegistroPagina);
        query.setMaxResults(totalRegistroPorPagina);
    }

    private long total(LancamentoFilter lan) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<Lancamento> root = criteriaQuery.from(Lancamento.class);

        Predicate[] predicates = criarRestricoes(lan, builder, root);
        criteriaQuery.where(predicates);
        criteriaQuery.select(builder.count(root));
        return manager.createQuery(criteriaQuery).getSingleResult();
    }
  
}
