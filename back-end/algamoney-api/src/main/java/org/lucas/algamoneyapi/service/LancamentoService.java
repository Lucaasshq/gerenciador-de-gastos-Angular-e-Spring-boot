package org.lucas.algamoneyapi.service;

import org.lucas.algamoneyapi.dto.LancamentoDTO;
import org.lucas.algamoneyapi.dto.Mapper.LancamentoMapper;
import org.lucas.algamoneyapi.exeception.CategoriaNaoEncontradaException;
import org.lucas.algamoneyapi.exeception.LancamentoNaoEncontradoException;
import org.lucas.algamoneyapi.exeception.PessoaInativaException;
import org.lucas.algamoneyapi.exeception.PessoaNaoEncontradaException;
import org.lucas.algamoneyapi.model.Categoria;
import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.model.Pessoa;
import org.lucas.algamoneyapi.repository.CategoriaRepository;
import org.lucas.algamoneyapi.repository.LancamentoRepository;
import org.lucas.algamoneyapi.repository.PessoaRepository;
import org.lucas.algamoneyapi.repository.filter.LancamentoFilter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    private final LancamentoRepository lancamentoRepository;

    private final PessoaRepository pessoaRepository;

    private final CategoriaRepository categoriaRepository;

    LancamentoService(LancamentoRepository lancamentoRepository, PessoaRepository pessoaRepository, CategoriaRepository categoriaRepository) {
        this.lancamentoRepository = lancamentoRepository;
        this.pessoaRepository = pessoaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Lancamento> buscarTodos(LancamentoFilter filter){
        return lancamentoRepository.findAll();
    }

    public List<Lancamento> pesquisarLancamento(){
        return lancamentoRepository.findAll();
    }

    public Lancamento buscarPorId(Long id){
        return lancamentoRepository.findById(id).orElseThrow(() -> new LancamentoNaoEncontradoException("Lançamento de " +id+ " não encontrado"));
    }

    public LancamentoDTO salvar(LancamentoDTO lancamentoDTO){
        Pessoa pessoaEncontrada = pessoaRepository.findById(lancamentoDTO.getPessoa().getId()).orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa de " +lancamentoDTO.getPessoa().getId()+ " não encontrado"));
        if (!pessoaEncontrada.getAtivo()){
            throw new PessoaInativaException("Pessoa de id " +lancamentoDTO.getPessoa().getId()+ " inativo");
        }
        Categoria categoriaEncontrada = categoriaRepository.findById(lancamentoDTO.getCategoria().getId()).orElseThrow(() -> new CategoriaNaoEncontradaException("Categoria de "+lancamentoDTO.getCategoria().getId()+ " não encontrada"));

       Lancamento entity = LancamentoMapper.toEntity(lancamentoDTO, pessoaEncontrada, categoriaEncontrada);
       Lancamento salvo = lancamentoRepository.save(entity);
       return LancamentoMapper.toDto(salvo);
    }
    

    public void excluir(Long id){
        if (!lancamentoRepository.existsById(id)){
            throw new RuntimeException("Teste: id não encontrado Lancamento repostory exluir");
        };
        lancamentoRepository.deleteById(id);
    }
}
