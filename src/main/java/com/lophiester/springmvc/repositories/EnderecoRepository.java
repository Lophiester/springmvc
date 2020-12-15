package com.lophiester.springmvc.repositories;

import com.lophiester.springmvc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {
}
