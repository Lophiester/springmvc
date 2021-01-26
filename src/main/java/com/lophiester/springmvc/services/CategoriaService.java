package com.lophiester.springmvc.services;

import com.lophiester.springmvc.domain.Categoria;
import com.lophiester.springmvc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(null);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Page<Categoria> findPage(Integer page, Integer size, Sort.Direction direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, size, direction, orderBy);
        return categoriaRepository.findAll(pageRequest);
    }

    public Categoria update(Categoria obj) {
        findById(obj.getId());
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        categoriaRepository.deleteById(id);
    }
}
