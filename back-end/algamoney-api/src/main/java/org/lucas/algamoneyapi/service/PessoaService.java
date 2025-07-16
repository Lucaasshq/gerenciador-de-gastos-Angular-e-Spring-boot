package org.lucas.algamoneyapi.service;

import org.lucas.algamoneyapi.dto.PessoaDTO;
import org.lucas.algamoneyapi.exeception.PessoaNaoEncontradaException;
import org.lucas.algamoneyapi.model.Endereco;
import org.lucas.algamoneyapi.model.Pessoa;
import org.lucas.algamoneyapi.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
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

    public Pessoa atualizar(Long id, PessoaDTO pessoaDTO){
       Pessoa pessoaEncontrada = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa com esse ID "+id+ " não encontrada"));

       pessoaEncontrada.setNome(pessoaDTO.getNome());
       pessoaEncontrada.setAtivo(pessoaDTO.getAtivo());

       if (pessoaDTO.getEndereco() != null){
           Endereco endereco = new Endereco();
           endereco.setLogradouro(pessoaDTO.getEndereco().getLogradouro());
           endereco.setCep(pessoaDTO.getEndereco().getCep());
           endereco.setNumero(pessoaDTO.getEndereco().getNumero());
           endereco.setComplemento(pessoaDTO.getEndereco().getComplemento());
           endereco.setBairro(pessoaDTO.getEndereco().getBairro());
           endereco.setCidade(pessoaDTO.getEndereco().getCidade());
           endereco.setEstado(pessoaDTO.getEndereco().getEstado());

           pessoaEncontrada.setEndereco(endereco);
       }


        return pessoaRepository.save(pessoaEncontrada);
    }

    public void atualizarPropriedadeAtivo(Long id, Boolean ativo) {
        Pessoa pessoaEncontrada = pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa com esse ID "+id+ " não encontrada"));
        pessoaEncontrada.setAtivo(ativo);
        pessoaRepository.save(pessoaEncontrada);
    }
}
