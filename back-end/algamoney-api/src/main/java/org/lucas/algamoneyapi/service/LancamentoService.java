package org.lucas.algamoneyapi.service;

import org.lucas.algamoneyapi.exeception.LancamentoNaoEncontradoException;
import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.repository.LancamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;

    LancamentoService(LancamentoRepository lancamentoRepository){
        this.lancamentoRepository = lancamentoRepository;
    }

    public List<Lancamento> buscarTodos(){
        return lancamentoRepository.findAll();
    }

    public Lancamento buscarPorId(Long id){
        return lancamentoRepository.findById(id).orElseThrow(() -> new LancamentoNaoEncontradoException("Lançamento de " +id+ " não encontrado"));
    }

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public void excluir(Long id){
        if (!lancamentoRepository.existsById(id)){
            throw new RuntimeException("Teste: id não encontrado Lancamento repostory exluir");
        };
        lancamentoRepository.deleteById(id);
    }
}
