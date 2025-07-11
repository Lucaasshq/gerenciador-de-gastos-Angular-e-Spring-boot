package org.lucas.algamoneyapi.repository;

import lombok.Getter;
import org.lucas.algamoneyapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
