package com.lophiester.springmvc.repositories;

import com.lophiester.springmvc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
