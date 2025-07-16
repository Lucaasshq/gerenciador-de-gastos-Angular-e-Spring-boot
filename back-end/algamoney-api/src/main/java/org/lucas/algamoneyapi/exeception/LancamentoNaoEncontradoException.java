package org.lucas.algamoneyapi.exeception;

public class LancamentoNaoEncontradoException extends RuntimeException {
    public LancamentoNaoEncontradoException(String message) {
        super(message);
    }
}
