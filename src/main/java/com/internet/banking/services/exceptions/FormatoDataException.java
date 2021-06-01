package com.internet.banking.services.exceptions;

public class FormatoDataException extends RuntimeException {

    public FormatoDataException(Object id) {
        super("O padrão de data informado esta invalido, Utilize o formato: yyyy-MM-dd.");
    }
}