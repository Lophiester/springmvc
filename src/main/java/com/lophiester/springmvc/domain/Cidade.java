package com.lophiester.springmvc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cidade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Nome;

    @ManyToOne()
    @JsonIgnore
    private Estado estados;

    public Cidade() {
    }

    public Cidade(Integer id, String nome, Estado estados) {
        this.id = id;
        Nome = nome;
        this.estados = estados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Estado getEstados() {
        return estados;
    }

    public void setEstados(Estado estados) {
        this.estados = estados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cidade cidade = (Cidade) o;

        return id.equals(cidade.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
