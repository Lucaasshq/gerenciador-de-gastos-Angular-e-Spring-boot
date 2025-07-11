package org.lucas.algamoneyapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name = "categoria")
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
