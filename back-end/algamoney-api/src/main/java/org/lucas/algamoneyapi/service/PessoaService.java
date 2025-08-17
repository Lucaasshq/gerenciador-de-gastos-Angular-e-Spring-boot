package org.lucas.algamoneyapi.service;


import org.lucas.algamoneyapi.exeception.PessoaNaoEncontradaException;
import org.lucas.algamoneyapi.model.Endereco;
import org.lucas.algamoneyapi.model.Pessoa;
import org.lucas.algamoneyapi.repository.PessoaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Pessoa atualizar(Long id, Pessoa pessoa){
       Pessoa pessoaEncontrada = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa com esse ID "+id+ " não encontrada"));

       pessoaEncontrada.setNome(pessoa.getNome());
       pessoaEncontrada.setAtivo(pessoa.getAtivo());

       if (pessoa.getEndereco() != null){
           Endereco endereco = getEndereco(pessoa);

           pessoaEncontrada.setEndereco(endereco);
       }


        return pessoaRepository.save(pessoaEncontrada);
    }

    private Endereco getEndereco(Pessoa pessoa) {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(pessoa.getEndereco().getLogradouro());
        endereco.setCep(pessoa.getEndereco().getCep());
        endereco.setNumero(pessoa.getEndereco().getNumero());
        endereco.setComplemento(pessoa.getEndereco().getComplemento());
        endereco.setBairro(pessoa.getEndereco().getBairro());
        endereco.setCidade(pessoa.getEndereco().getCidade());
        endereco.setEstado(pessoa.getEndereco().getEstado());
        return endereco;
    }

    public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
        Pessoa pessoaEncontrada = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa com esse ID "+id+ " não encontrada"));
        pessoaEncontrada.setAtivo(ativo);
        pessoaRepository.save(pessoaEncontrada);
    }

    public Page<Pessoa> buscarPorNome(String nome, Pageable pageable) {
        return pessoaRepository.buscarPorNome(nome, pageable);
    }
}
