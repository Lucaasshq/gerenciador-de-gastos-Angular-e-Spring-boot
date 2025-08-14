package org.lucas.algamoneyapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.lucas.algamoneyapi.model.enums.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LancamentoAtualizarDTO {
    @NotNull
    private String descricao;

    @NotNull
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    @NotNull
    @Positive
    private BigDecimal valor;

    private String observacao;

    @NotNull
    private TipoLancamento tipo;

    @NotNull
    private Long categoriaId; // só o ID da categoria

    @NotNull
    private Long pessoaId; // só o ID da pessoa
}
