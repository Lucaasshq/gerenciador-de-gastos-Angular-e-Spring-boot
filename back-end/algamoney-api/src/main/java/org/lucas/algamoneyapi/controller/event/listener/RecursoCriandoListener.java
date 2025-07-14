package org.lucas.algamoneyapi.controller.event.listener;

import org.lucas.algamoneyapi.controller.event.RecursoCriadoEvent;
import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Component
public class RecursoCriandoListener {

    @EventListener
    public void adicionandoHeaderLocation(RecursoCriadoEvent event){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(event.getId())
                .toUri();

        event.getResponse().setHeader("Location", uri.toString());
    }
}
