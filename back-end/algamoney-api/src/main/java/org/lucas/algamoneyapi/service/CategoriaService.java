package org.lucas.algamoneyapi.service;


import jakarta.persistence.EntityNotFoundException;
import org.lucas.algamoneyapi.exeception.CategoriaNaoEncontradaException;

import org.lucas.algamoneyapi.model.Categoria;
import org.lucas.algamoneyapi.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class CategoriaService {


    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria salvar(Categoria categoria){
       return categoriaRepository.save(categoria);
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException("Categoria com ID " + id +" Não encontrada"));
    }
}
