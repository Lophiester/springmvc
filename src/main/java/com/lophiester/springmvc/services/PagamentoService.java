package com.lophiester.springmvc.services;

import com.lophiester.springmvc.domain.Pagamento;
import com.lophiester.springmvc.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository PagamentoRepository;

    public Pagamento findById(Integer id) {
        Optional<Pagamento> obj = PagamentoRepository.findById(id);
        return obj.orElseThrow(null);
    }

}
