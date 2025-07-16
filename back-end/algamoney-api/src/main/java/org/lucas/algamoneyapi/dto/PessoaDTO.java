package org.lucas.algamoneyapi.dto;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PessoaDTO {
    @Size(min = 5, max = 50)
    @NotBlank
    private String nome;

    @NotNull
    private Boolean ativo;


    private EnderecoDTO endereco;


}
