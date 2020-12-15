package com.lophiester.springmvc.repositories;

import com.lophiester.springmvc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
