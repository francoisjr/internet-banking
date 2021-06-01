package com.internet.banking.entities.enums;

public enum TipoTransacao {

   SAQUE(1),
    DEPOSITO(2);

    private int code;

    TipoTransacao(int code)  {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoTransacao valueOf(int code) {
        for (TipoTransacao value : TipoTransacao.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Tipo de transação invalido");
    }
}