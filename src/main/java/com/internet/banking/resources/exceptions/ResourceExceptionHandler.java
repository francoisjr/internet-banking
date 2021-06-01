package com.internet.banking.resources.exceptions;

import com.internet.banking.services.exceptions.ClienteNaoEncontradoException;
import com.internet.banking.services.exceptions.FormatoDataException;
import com.internet.banking.services.exceptions.NumeroFormatException;
import com.internet.banking.services.exceptions.SaldoInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    public ResponseEntity<StandardError> resourceNotFound(ClienteNaoEncontradoException e, HttpServletRequest request) {
        String error = "Cliente não encontrado!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NumeroFormatException.class)
    public ResponseEntity<StandardError> numeroFormatException(NumeroFormatException e, HttpServletRequest request) {
        String error = "Numero invalido!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(FormatoDataException.class)
    public ResponseEntity<StandardError> numeroFormatException(FormatoDataException e, HttpServletRequest request) {
        String error = "Formato de data invalido!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<StandardError> numeroFormatException(SaldoInsuficienteException e, HttpServletRequest request) {
        String error = "Saque maior que o saldo da conta!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
