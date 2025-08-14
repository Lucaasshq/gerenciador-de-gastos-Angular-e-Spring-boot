package org.lucas.algamoneyapi.controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.lucas.algamoneyapi.dto.LancamentoAtualizarDTO;
import org.lucas.algamoneyapi.dto.LancamentoDTO;
import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.repository.filter.LancamentoFilter;
import org.lucas.algamoneyapi.repository.projection.LancamentoProjection;
import org.lucas.algamoneyapi.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    ApplicationEventPublisher publisher;


    @GetMapping
    @PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
    public ResponseEntity<Page<Lancamento>> filtrar(LancamentoFilter filter, Pageable pageable){
        return ResponseEntity.ok(lancamentoService.pesquisarLancamento(filter, pageable));
    }

    @GetMapping("/resumo")
    @PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
    public ResponseEntity<Page<LancamentoProjection>> resumo(Pageable pageable){
        return ResponseEntity.ok(lancamentoService.resumo(pageable));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
    public ResponseEntity<Lancamento> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(lancamentoService.buscarPorId(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
    public ResponseEntity<LancamentoDTO> criarLancamento(@Valid @RequestBody LancamentoDTO dto, HttpServletResponse response){
        LancamentoDTO lancamentoSalvo = lancamentoService.salvar(dto);
//        publisher.publishEvent(new RecursoCriadoEvent(response, lancamentoSalvo.ge));
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> excluirLancamento(@PathVariable Long id){
        lancamentoService.excluir(id);
       return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('USUARIO', 'ADMIN')")
    public ResponseEntity<Lancamento> atualiza(@PathVariable Long id, @Valid @RequestBody LancamentoAtualizarDTO lancamento){
        return ResponseEntity.ok().body(lancamentoService.atualizar(id, lancamento));
    }
}
