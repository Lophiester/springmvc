package com.lophiester.springmvc.resources;

import com.lophiester.springmvc.domain.Cidade;
import com.lophiester.springmvc.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findBydId(@PathVariable Integer id) {
        Cidade obj = cidadeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
