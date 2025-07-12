package org.lucas.algamoneyapi.exeception;

public class CategoriaNaoEncontradaException  extends RuntimeException {
    public CategoriaNaoEncontradaException (String message){
        super(message);
    }
}
