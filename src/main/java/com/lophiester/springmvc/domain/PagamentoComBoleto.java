package com.lophiester.springmvc.domain;

import com.lophiester.springmvc.enums.EstadoPagemento;

public class PagamentoComBoleto extends Pagamento {

    private Integer numeroDeParcelas;

    public PagamentoComBoleto(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public PagamentoComBoleto(Integer id, EstadoPagemento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
