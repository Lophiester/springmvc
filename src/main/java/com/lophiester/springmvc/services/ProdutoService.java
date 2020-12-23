package com.lophiester.springmvc.services;

import com.lophiester.springmvc.domain.Produto;
import com.lophiester.springmvc.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Integer id){
        Optional<Produto>obj = produtoRepository.findById(id);
        return obj.orElseThrow(null);

    }

}
