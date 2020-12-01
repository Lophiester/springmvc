package com.lophiester.springmvc.services;

import com.lophiester.springmvc.domain.Cidade;
import com.lophiester.springmvc.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade findById(Integer id){
        Optional<Cidade>obj = cidadeRepository.findById(id);
        return obj.orElseThrow(null);
    }

}
