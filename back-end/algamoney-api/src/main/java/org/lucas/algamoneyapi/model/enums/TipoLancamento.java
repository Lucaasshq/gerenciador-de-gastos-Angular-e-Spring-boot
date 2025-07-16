package org.lucas.algamoneyapi.model.enums;

import lombok.Getter;

@Getter
public enum TipoLancamento {

    RECEITA("receita"),
    DESPESA("despesa");

    private final String tipo;

     TipoLancamento(String tipo){
        this.tipo = tipo;
    }

}
