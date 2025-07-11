package org.lucas.algamoneyapi.exeception;

import org.lucas.algamoneyapi.dto.ErroDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CategoriaNaoEncontradaExeception.class)
    public ResponseEntity<ErroDTO> handlerCategoriaNaoEncontrada(CategoriaNaoEncontradaExeception ex){
        ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(erroDTO.getStatusCode()).body(erroDTO);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErroDTO erroDTO = new ErroDTO(status.value(), "Json com campos inválidos");
        return handleExceptionInternal(ex, erroDTO, headers , HttpStatus.BAD_REQUEST, request);
    }
}
