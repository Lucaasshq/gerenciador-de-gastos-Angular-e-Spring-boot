package org.lucas.algamoneyapi.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.lucas.algamoneyapi.controller.event.RecursoCriadoEvent;
import org.lucas.algamoneyapi.model.Categoria;
import org.lucas.algamoneyapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping()
    public ResponseEntity<List<Categoria>> listarCategorias(){
        List<Categoria> categoriaList = categoriaService.buscarTodos();
        return ResponseEntity.ok(categoriaList);
    }

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoriaSalva = categoriaService.salvar(categoria);
        publisher.publishEvent(new RecursoCriadoEvent(response, categoriaSalva.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
            Categoria cEncontrada = categoriaService.buscarPorId(id);
            return  ResponseEntity.ok(cEncontrada);
    }
}
