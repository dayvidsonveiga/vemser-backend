package br.com.vemser.pessoaapi.enums;

import java.util.Arrays;

public enum TipoContato {

    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

}