package org.lucas.algamoneyapi.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.lucas.algamoneyapi.controller.event.RecursoCriadoEvent;
import org.lucas.algamoneyapi.dto.PessoaDTO;
import org.lucas.algamoneyapi.model.Pessoa;
import org.lucas.algamoneyapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @Autowired
    ApplicationEventPublisher publisher;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(response, pessoaSalva.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarDados(@PathVariable Long id,@Valid @RequestBody PessoaDTO pessoaDTO){
       return ResponseEntity.ok(pessoaService.atualizar(id, pessoaDTO)) ;
    }

    @PutMapping("/{id}/ativo")
    public ResponseEntity<Void> atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo){
        pessoaService.atualizarPropriedadeAtivo(id, ativo);
        return ResponseEntity.noContent().build();
    }
}
