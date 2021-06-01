package com.internet.banking.services.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {

    public ClienteNaoEncontradoException(Object id) {
        super("Cliente não encontrado. ID: "+ id);
    }
}
