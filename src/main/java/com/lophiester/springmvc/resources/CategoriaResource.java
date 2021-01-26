package com.lophiester.springmvc.resources;

import com.lophiester.springmvc.domain.Categoria;
import com.lophiester.springmvc.dto.CategoriaDTO;
import com.lophiester.springmvc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>>findAll(){
        List<Categoria>list= categoriaService.findAll();
        List<CategoriaDTO>listDTO= list.stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @GetMapping(value = "/pages")
    public ResponseEntity<Page<CategoriaDTO>>findPage(
           @RequestParam(value = "page", defaultValue = "0") Integer page,
           @RequestParam (value = "size",defaultValue = "24")Integer size,
           @RequestParam(value = "direction", defaultValue = "ASC")  Sort.Direction direction,
           @RequestParam(value = "orderBy",defaultValue = "name")   String orderBy){
        Page<Categoria>list= categoriaService.findPage(page,size,direction,orderBy);
        Page<CategoriaDTO>listDto= list.map(categoria -> new CategoriaDTO(categoria));
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
        obj = categoriaService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
        obj.setId(id);
        categoriaService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
