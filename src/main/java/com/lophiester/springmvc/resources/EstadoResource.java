package com.lophiester.springmvc.resources;

import com.lophiester.springmvc.domain.Estado;
import com.lophiester.springmvc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;
    @GetMapping(value="/{id}")
    public ResponseEntity<?>findById(@PathVariable Integer id){
        Estado obj = estadoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
