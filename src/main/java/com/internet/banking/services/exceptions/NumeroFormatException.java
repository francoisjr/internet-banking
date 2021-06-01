package com.internet.banking.services.exceptions;

public class NumeroFormatException extends RuntimeException {

    public NumeroFormatException(Object id) {
        super("Valor invalido, utilize um valor maior que zero e o formato: #.##: "+ id);
    }
}
