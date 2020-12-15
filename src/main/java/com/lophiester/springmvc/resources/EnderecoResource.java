package com.lophiester.springmvc.resources;

import com.lophiester.springmvc.domain.Endereco;
import com.lophiester.springmvc.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<?> findById(@PathVariable Integer id) {
        Endereco obj = enderecoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

