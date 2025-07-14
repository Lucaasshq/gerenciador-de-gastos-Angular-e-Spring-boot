package org.lucas.algamoneyapi.service;

import org.lucas.algamoneyapi.exeception.PessoaNaoEncontradaException;
import org.lucas.algamoneyapi.model.Pessoa;
import org.lucas.algamoneyapi.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){this.pessoaRepository = pessoaRepository;}

    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id){
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa de ID " + id +" não encontrado"));
    }

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    public void excluir(Long id){
       if (!pessoaRepository.existsById(id)){
           throw new PessoaNaoEncontradaException("Pessoa de ID "+ id + " Não encontrada");
       };
       pessoaRepository.deleteById(id);
    }
}
