package org.lucas.algamoneyapi.controller;

import org.lucas.algamoneyapi.model.Categoria;
import org.lucas.algamoneyapi.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping()
    public ResponseEntity<List<Categoria>> listarCategorias(){
        List<Categoria> categoriaList = categoriaService.buscarTodos();
        return ResponseEntity.ok(categoriaList);
    }

    @PostMapping
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria){
        Categoria categoriaSalva = categoriaService.salvar(categoria);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaSalva.getId())
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(categoriaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
            Categoria cEncontrada = categoriaService.buscarPorId(id);
            return  ResponseEntity.ok(cEncontrada);
    }
}
