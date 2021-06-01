package com.internet.banking.services.exceptions;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super("Saldo insuficiente. Faça um depósito!");
    }
}
