package com.lophiester.springmvc.services;

import com.lophiester.springmvc.domain.Cidade;
import com.lophiester.springmvc.domain.Cliente;
import com.lophiester.springmvc.domain.Endereco;
import com.lophiester.springmvc.domain.enums.TipoCliente;
import com.lophiester.springmvc.dto.ClienteDTO;
import com.lophiester.springmvc.dto.ClienteNewDTO;
import com.lophiester.springmvc.repositories.ClienteRepository;
import com.lophiester.springmvc.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(null);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linePerPage, String orderBy, Sort.Direction direction) {
        PageRequest pageRequest = PageRequest.of(page, linePerPage, direction, orderBy);
        return clienteRepository.findAll(pageRequest);

    }

    //caso tire obj do findById FAZER TESTE
    @Transactional
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = clienteRepository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = findById(obj.getId());
        updateData(newObj, obj);
        return clienteRepository.save(newObj);

    }

    public void delete(Integer id) {
        findById(id);
        clienteRepository.deleteAll();
    }


    public Cliente fromDTO(ClienteDTO objDto) {
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }

    public Cliente fromDTO(ClienteNewDTO objDto) {
        Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
        Endereco en = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
        cli.getEnderecos().add(en);
        cli.getTelefones().add(objDto.getTelefone1());
        if (objDto.getTelefone2() != null) {
            cli.getTelefones().add(objDto.getTelefone2());
        }
        if (objDto.getTelefone3() != null) {
            cli.getTelefones().add(objDto.getTelefone3());
        }
        return cli;
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}
