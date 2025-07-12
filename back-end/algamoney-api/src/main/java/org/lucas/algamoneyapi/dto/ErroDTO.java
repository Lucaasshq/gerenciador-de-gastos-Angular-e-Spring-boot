package org.lucas.algamoneyapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ErroDTO {
    private int statusCode;
    private String developerMessage;
    private String userMessage;
    private LocalDateTime timestamp;

    public ErroDTO(int statusCode, String developerMessage, String userMesage){
        this.statusCode = statusCode;
        this.developerMessage = developerMessage;
        this.userMessage = userMesage;
        this.timestamp = LocalDateTime.now();
    }
}
