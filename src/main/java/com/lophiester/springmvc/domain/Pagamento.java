package com.lophiester.springmvc.domain;

import com.lophiester.springmvc.enums.EstadoPagemento;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pagamento implements Serializable {
    @Id
    private Integer id;
    private EstadoPagemento estado;

    @OneToOne
    @MapsId
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Pagamento() {
    }

    public Pagamento(Integer id, EstadoPagemento estado, Pedido pedido) {
        this.id = id;
        this.estado = estado;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagemento getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagemento estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pagamento pagamento = (Pagamento) o;

        return id.equals(pagamento.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
