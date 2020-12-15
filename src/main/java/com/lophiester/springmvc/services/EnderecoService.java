package com.lophiester.springmvc.services;

import com.lophiester.springmvc.domain.Endereco;
import com.lophiester.springmvc.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco findById(Integer id){
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(null);
    }
}
