package org.lucas.algamoneyapi.exeception;

public class CategoriaNaoEncontradaExeception extends RuntimeException {
    public CategoriaNaoEncontradaExeception(String message){
        super(message);
    }
}
