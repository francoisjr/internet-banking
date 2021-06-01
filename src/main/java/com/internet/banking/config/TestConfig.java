package com.internet.banking.config;

import com.internet.banking.entities.Cliente;
import com.internet.banking.entities.Transacao;
import com.internet.banking.entities.enums.TipoTransacao;
import com.internet.banking.repositories.ClienteRepository;
import com.internet.banking.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente = new Cliente(null, "Francisco", false, 500.00, 4776,
                LocalDate.parse("2000-07-22", DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Cliente cliente2 = new Cliente(null, "Lucas", false, 350.00, 6461,
                LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        Cliente cliente3 = new Cliente(null, "Lucas 2", true, 1200.00, 6461,
                LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Cliente cliente4 = new Cliente(null, "Lucas 3", true, 350.00, 78641,
                LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Cliente cliente5 = new Cliente(null, "Lucas 4", false, 754.00, 1230,
                LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Cliente cliente6 = new Cliente(null, "Lucas 5", false, 651.00, 3965,
                LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Cliente cliente7 = new Cliente(null, "Lucas 7", true, 651.00, 3965,
                LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Cliente cliente8 = new Cliente(null, "Lucas 5", false, 651.00, 3965,
                LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Cliente cliente9 = new Cliente(null, "Lucas 5", true, 651.00, 3965,
                LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        clienteRepository.saveAll(Arrays.asList(cliente, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8, cliente9));

        Transacao transacao1 = new Transacao(null, TipoTransacao.SAQUE, LocalDate.now(), cliente);
        Transacao transacao2 = new Transacao(null, TipoTransacao.DEPOSITO, LocalDate.now(), cliente2);
        Transacao transacao3 = new Transacao(null, TipoTransacao.SAQUE, LocalDate.now(),cliente3);
        Transacao transacao4 = new Transacao(null, TipoTransacao.DEPOSITO, LocalDate.now(), cliente7);
        Transacao transacao5 = new Transacao(null, TipoTransacao.DEPOSITO, LocalDate.now(), cliente9);
        Transacao transacao6 = new Transacao(null, TipoTransacao.SAQUE, LocalDate.now(), cliente6);
        Transacao transacao7 = new Transacao(null, TipoTransacao.SAQUE, LocalDate.now(), cliente);
        Transacao transacao8 = new Transacao(null, TipoTransacao.DEPOSITO, LocalDate.now(), cliente2);

        transacaoRepository.saveAll(Arrays.asList(transacao1, transacao2, transacao3, transacao4, transacao5, transacao6, transacao7, transacao8));

    }
}
