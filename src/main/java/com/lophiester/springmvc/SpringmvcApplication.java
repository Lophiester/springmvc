package com.lophiester.springmvc;

import com.lophiester.springmvc.domain.*;
import com.lophiester.springmvc.repositories.*;
import com.lophiester.springmvc.enums.TipoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringmvcApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepossitory produtoRepossitory;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringmvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informatica");
        Categoria cat2 = new Categoria(null, "Escitorio");
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        produtoRepossitory.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Sao Paulo");
        Estado est2 = new Estado(null, "Minas Gerais");

        estadoRepository.saveAll(Arrays.asList(est1, est2));

        Cidade cid1 = new Cidade(null, "Guarulhos", est1);
        Cidade cid2 = new Cidade(null, "Campinas", est1);
        Cidade cid3 = new Cidade(null, "Uberlandia", est2);

        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        est1.getCidades().addAll(Arrays.asList(cid1, cid2));
        est2.getCidades().addAll(Arrays.asList(cid3));

        Cliente cli1 = new Cliente(null, "Maria Ross", "maria@gmail.com", "1234567", TipoCliente.PESSOAFISICA);
        Cliente cli2 = new Cliente(null, "Luna Mises", "luna@gmail.com", "1234567", TipoCliente.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("08012345"));
        cli2.getTelefones().addAll(Arrays.asList("09012345"));

        Endereco e1 = new Endereco(null, "rua Flores", "300", "Apto 203", "Jardim", "070123450", cli1, cid1);
        Endereco e2 = new Endereco(null, "rua Flores", "200", "Sala 203", "Centro", "070123450", cli1, cid2);

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

    }
}
