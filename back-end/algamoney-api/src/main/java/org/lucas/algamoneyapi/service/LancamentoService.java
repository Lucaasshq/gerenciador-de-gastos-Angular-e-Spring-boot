package org.lucas.algamoneyapi.service;

import jakarta.validation.Valid;
import org.lucas.algamoneyapi.dto.LancamentoAtualizarDTO;
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
import org.lucas.algamoneyapi.repository.projection.LancamentoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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



    public Page<Lancamento> pesquisarLancamento(LancamentoFilter filter, Pageable pageable){
        return lancamentoRepository.filtrar(filter, pageable);
    }

    public List<Lancamento> buscarTodos(){
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
            throw new LancamentoNaoEncontradoException("Lançamento de id " +id+ " não encontrado ou já removido");
        };
        lancamentoRepository.deleteById(id);
    }

    public Page<LancamentoProjection> resumo(Pageable pageable) {
        return lancamentoRepository.lancamentoProjection(pageable);
    }

    public  Lancamento atualizar(Long id, @Valid LancamentoAtualizarDTO lancamento) {
        Lancamento lancamento1 = buscarPorId(id);

        Pessoa pessoaEncontrada = pessoaRepository.findById(lancamento.getPessoaId()).orElseThrow(
                () -> new PessoaNaoEncontradaException("Pessoa não encontrada")
        );
        boolean ativo = pessoaEncontrada.getAtivo();
        boolean pessoaExiste = pessoaRepository.existsById(lancamento.getPessoaId());

        if (!pessoaExiste){
            throw new PessoaNaoEncontradaException("Pessoa não encontrada ");
        }

        if (!ativo) {
            throw new PessoaInativaException("Pessoa de nome "+lancamento.getPessoaId()+ " está inativa");
        }

        Categoria categoria = categoriaRepository.findById(lancamento.getCategoriaId()).orElseThrow(
                ()-> new CategoriaNaoEncontradaException("Categoria não encontrada")
        );


        lancamento1.setDescricao(lancamento.getDescricao());
        lancamento1.setDataVencimento(lancamento.getDataVencimento());
        lancamento1.setDataPagamento(lancamento.getDataPagamento());
        lancamento1.setValor(lancamento.getValor());
        lancamento1.setObservacao(lancamento.getObservacao());
        lancamento1.setTipo(lancamento.getTipo());
        lancamento1.setCategoria(categoria);
        lancamento1.setPessoa(pessoaEncontrada);


        return lancamentoRepository.save(lancamento1);

    }

}
