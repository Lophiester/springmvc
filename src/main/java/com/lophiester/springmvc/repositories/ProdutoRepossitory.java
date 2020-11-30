package com.lophiester.springmvc.repositories;

import com.lophiester.springmvc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepossitory extends JpaRepository<Produto,Integer> {
}
