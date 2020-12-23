package com.lophiester.springmvc.domain.enums;

public enum EstadoPagemento {

    QUITADO(1, "Quitado"),
    PENDENTE(2, "Pendente"),
    CANCELADO(3, "Cancelado");

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
