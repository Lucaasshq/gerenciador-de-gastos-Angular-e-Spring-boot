package org.lucas.algamoneyapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import org.lucas.algamoneyapi.model.Pessoa;
import org.lucas.algamoneyapi.model.enums.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LancamentoDTO {

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate dataVencimento;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private TipoLancamento tipo;

    @NotNull
    private CategoriaDTO categoria;

    @NotNull
    private PessoaIdDTO pessoa;
}
