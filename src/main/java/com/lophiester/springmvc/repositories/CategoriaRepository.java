package com.lophiester.springmvc.repositories;

import com.lophiester.springmvc.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
