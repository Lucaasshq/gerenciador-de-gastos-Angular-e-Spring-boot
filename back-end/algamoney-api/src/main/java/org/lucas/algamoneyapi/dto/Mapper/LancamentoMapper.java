package org.lucas.algamoneyapi.dto.Mapper;

import org.lucas.algamoneyapi.dto.CategoriaDTO;
import org.lucas.algamoneyapi.dto.LancamentoDTO;
import org.lucas.algamoneyapi.dto.PessoaIdDTO;
import org.lucas.algamoneyapi.model.Categoria;
import org.lucas.algamoneyapi.model.Lancamento;
import org.lucas.algamoneyapi.model.Pessoa;

public class LancamentoMapper {

    public static Lancamento toEntity(LancamentoDTO dto, Pessoa pessoa, Categoria categoria){
        Lancamento lancamento = new Lancamento();
        lancamento.setDescricao(dto.getDescricao());
        lancamento.setDataVencimento(dto.getDataVencimento());
        lancamento.setValor(dto.getValor());
        lancamento.setTipo(dto.getTipo());
        lancamento.setPessoa(pessoa);
        lancamento.setCategoria(categoria);
        return lancamento;
    }

    public static LancamentoDTO toDto(Lancamento lancamento){
        LancamentoDTO dto = new LancamentoDTO();
        dto.setDescricao(lancamento.getDescricao());
        dto.setDataVencimento(lancamento.getDataVencimento());
        dto.setValor(lancamento.getValor());
        dto.setTipo(lancamento.getTipo());

        PessoaIdDTO pessoaIdDTO = new PessoaIdDTO();
        pessoaIdDTO.setId(lancamento.getPessoa().getId());
        dto.setPessoa(pessoaIdDTO);

        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(lancamento.getCategoria().getId());
        dto.setCategoria(categoriaDTO);
        return dto;
    }
}
