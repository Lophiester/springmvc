package com.lophiester.springmvc.resources;

import com.lophiester.springmvc.domain.Pagamento;
import com.lophiester.springmvc.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoResource {
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Pagamento obj = pagamentoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
