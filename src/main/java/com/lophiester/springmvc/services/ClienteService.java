package com.lophiester.springmvc.services;

import com.lophiester.springmvc.domain.Cliente;
import com.lophiester.springmvc.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> obj= clienteRepository.findById(id);
        return obj.orElseThrow(null);
    }
}
