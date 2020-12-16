package com.lophiester.springmvc.enums;

public enum EstadoPagemento {

    PAGAMENTOCOMBOLETO(1, "Pagamento com Boleto"),
    PAGAMENTOCOMCARTAO(2, "Pagamento com Cartao");

    private Integer cod;
    private String descricao;

    EstadoPagemento(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static EstadoPagemento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (EstadoPagemento x : EstadoPagemento.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("cod invalido" + cod);
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
}
