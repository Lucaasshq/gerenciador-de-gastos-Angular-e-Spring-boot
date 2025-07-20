package org.lucas.algamoneyapi.exeception;

import org.lucas.algamoneyapi.dto.ErroDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    public ResponseEntity<ErroDTO> handlerCategoriaNaoEncontrada(CategoriaNaoEncontradaException ex){
        ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Categoria não encontrada" );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDTO);
    }

    @ExceptionHandler(PessoaNaoEncontradaException.class)
    public ResponseEntity<ErroDTO> handlerPessoaNaoEncontrada(PessoaNaoEncontradaException ex){
        ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Pessoa não encontrada" );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroDTO> handleJsonArgumentoInvalido(HttpMessageNotReadableException ex) {
        ErroDTO erroDTO = new ErroDTO(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), "Campo com Dados inválidos.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDTO> handlerValidacaoCampo(MethodArgumentNotValidException ex){
        String msgUsuario = "Um ou mais campos estão inválidos. Corrija e tente novamente.";

        StringBuilder msgDesenvolvedor = new StringBuilder();
        for (FieldError f : ex.getBindingResult().getFieldErrors()){
            msgDesenvolvedor.append(f.getField())
                    .append(": ")
                    .append(f.getDefaultMessage())  // mensagem da anotação de validação
                    .append(" (valor rejeitado: ")
                    .append(f.getRejectedValue())
                    .append("); ");
        }
        ErroDTO erroDTO = new ErroDTO(HttpStatus.BAD_REQUEST.value(), msgDesenvolvedor.toString(), msgUsuario);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDTO);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroDTO> handlerdataIntegrityViolationException(DataIntegrityViolationException ex){
        String msgUsuario = "Operação não permitida!";


        ErroDTO erroDTO = new ErroDTO(HttpStatus.BAD_REQUEST.value(), ex.getLocalizedMessage(), msgUsuario);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDTO);
    }

    @ExceptionHandler(LancamentoNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> handlerLancamentoNaoEncontrada(LancamentoNaoEncontradoException ex){
        ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Lancamento não encontrado" );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDTO);
    }

    @ExceptionHandler(PessoaInativaException.class)
    public ResponseEntity<ErroDTO> handlerPessoaInativaException(PessoaInativaException ex){
        ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "Pessoa Inativa ou não existe");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDTO);
    }



}
