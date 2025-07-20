package org.lucas.algamoneyapi.repository.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class LancamentoFilter {
    private String descricao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataVencimento;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataPagamento;
}
