package com.lophiester.springmvc.resources;

import com.lophiester.springmvc.domain.Cliente;
import com.lophiester.springmvc.dto.ClienteDTO;
import com.lophiester.springmvc.dto.ClienteNewDTO;
import com.lophiester.springmvc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente obj = clienteService.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> list = clienteService.findAll();
        List<ClienteDTO> listDTO = list.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/pages")
    public ResponseEntity<Page<ClienteDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linePerPage", defaultValue = "3") Integer linePerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") Sort.Direction direction) {
        Page<Cliente> list = clienteService.findPage(page, linePerPage, orderBy, direction);
        Page<ClienteDTO> listDTO = list.map(cliente -> new ClienteDTO(cliente));
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDto) {
        Cliente obj = clienteService.fromDTO(objDto);
        obj = clienteService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id) {
        Cliente obj = clienteService.fromDTO(objDto);
        obj.setId(id);
        clienteService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
