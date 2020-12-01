package com.lophiester.springmvc.services;

import com.lophiester.springmvc.domain.Estado;
import com.lophiester.springmvc.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado findById(Integer id){
        Optional<Estado>obj = estadoRepository.findById(id);
        return obj.orElseThrow(null);
    }

}
