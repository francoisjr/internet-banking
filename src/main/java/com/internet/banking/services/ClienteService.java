package com.internet.banking.services;

import com.internet.banking.entities.Cliente;
import com.internet.banking.entities.Transacao;
import com.internet.banking.entities.enums.TipoTransacao;
import com.internet.banking.repositories.ClienteRepository;
import com.internet.banking.repositories.TransacaoRepository;
import com.internet.banking.services.exceptions.ClienteNaoEncontradoException;
import com.internet.banking.services.exceptions.NumeroFormatException;
import com.internet.banking.services.exceptions.SaldoInsuficienteException;
import com.internet.banking.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente sacar(Integer clientId, String valor) {
        Optional<Cliente> obj = clienteRepository.findById(clientId.longValue());
        obj.orElseThrow(() -> new ClienteNaoEncontradoException(clientId.longValue()));

        Double saldo = obj.get().getSaldo();

        Double valorDouble = Util.parseValue(valor);

        if (valorDouble <= 0.0) {
            throw new NumeroFormatException(valorDouble);
        }

        if (saldo >= valorDouble) {
            saldo -= aplicarTaxa(valorDouble, obj.get().isEhPlanoExclusive());
            obj.get().setSaldo(saldo);
            clienteRepository.save(obj.get());
            transacaoRepository.save(new Transacao(null, TipoTransacao.SAQUE, Util.parseData(LocalDate.now().toString()), obj.get()));
        } else {
            throw new SaldoInsuficienteException();
        }
        return obj.get();
    }

    public Cliente depositar(Integer clientId, String valor) {

        Optional<Cliente> obj = clienteRepository.findById(clientId.longValue());

        Double saldo = obj.get().getSaldo();

        Double valorDouble = Double.parseDouble(valor);
        if (valorDouble <= 0.0) {
            throw new NumeroFormatException(valorDouble);
        }
        saldo += valorDouble;
        obj.get().setSaldo(saldo);
        clienteRepository.save(obj.get());
        transacaoRepository.save(new Transacao(null, TipoTransacao.DEPOSITO, Util.parseData(LocalDate.now().toString()), obj.get()));
        return obj.get();
    }

    public static Double aplicarTaxa(Double valor, boolean ehPlanoExclusive) {

        double valorTaxado = 0;

        if (!ehPlanoExclusive) {
            if (valor > 100.0 && valor < 300.00) {
                valorTaxado = valor + (valor * 0.04);
            } else if (valor > 300.00) {
                valorTaxado = valor + (valor * 0.01);
            } else {
                valorTaxado = valor;
            }
        }
        return valorTaxado;
    }
}