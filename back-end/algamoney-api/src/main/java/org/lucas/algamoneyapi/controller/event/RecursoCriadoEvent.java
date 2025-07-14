package org.lucas.algamoneyapi.controller.event;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;

@Getter
public class RecursoCriadoEvent {

    private HttpServletResponse response;
    private Long id;

    public RecursoCriadoEvent(HttpServletResponse response, Long id){
        this.response = response;
        this.id = id;
    }
}
