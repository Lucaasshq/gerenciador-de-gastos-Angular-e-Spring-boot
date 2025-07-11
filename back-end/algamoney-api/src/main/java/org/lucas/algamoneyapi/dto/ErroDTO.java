package org.lucas.algamoneyapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ErroDTO {
    private int StatusCode;
    private String message;
    private LocalDateTime timestamp;

    public ErroDTO(int statusCode, String message){
        this.StatusCode = statusCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
