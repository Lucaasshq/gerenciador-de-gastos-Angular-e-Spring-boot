package org.lucas.algamoneyapi.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.lucas.algamoneyapi.controller.event.RecursoCriadoEvent;

import org.lucas.algamoneyapi.model.Pessoa;
import org.lucas.algamoneyapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        return ResponseEntity.ok(pessoaService.buscarTodos());
    }

    @GetMapping("/buscar")
    @PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
    public ResponseEntity<Page<Pessoa>> pesquisaPessoa(@RequestParam String nome, Pageable pageable){
       return ResponseEntity.ok().body(pessoaService.buscarPorNome(nome, pageable));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(response, pessoaSalva.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        pessoaService.excluir(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Pessoa> atualizarDados(@PathVariable Long id,@Valid @RequestBody Pessoa pessoa){
       return ResponseEntity.ok(pessoaService.atualizar(id, pessoa)) ;
    }

    @PutMapping("/{id}/ativo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo){
        pessoaService.atualizarPropriedadeAtivo(id, ativo);
        return ResponseEntity.noContent().build();
    }
}
