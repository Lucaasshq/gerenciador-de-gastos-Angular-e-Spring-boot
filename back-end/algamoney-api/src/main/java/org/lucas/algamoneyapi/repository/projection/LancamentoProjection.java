package org.lucas.algamoneyapi.repository.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.lucas.algamoneyapi.model.enums.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface LancamentoProjection {
    Long getId();
    String getDescricao();
    LocalDate getDataVencimento();
    LocalDate getDataPagamento();
    BigDecimal getValor();
    TipoLancamento getTipo();
    String getCategoria();
    String getPessoa();
}
