package com.internet.banking.services;

import com.internet.banking.entities.Cliente;
import com.internet.banking.repositories.ClienteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteServiceTest {

    @Mock
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;
    private Cliente cliente;

    @Test
    public void testDepositar() {
        cliente = new Cliente();
        cliente.setSaldo(100.0);
        cliente.setId(1L);
        cliente.setDataNascimento(LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        cliente.setNome("Francisco");
        cliente.setNumeroConta(8664);
        cliente.setEhPlanoExclusive(false);
        Double valorDeposito = 100.0;
        clienteService.depositar(1, "100");
        when(clienteService.depositar(1, "100.0")).thenReturn(cliente);

        clienteRepository.save(cliente);

        assertEquals(valorDeposito, cliente.getSaldo());
    }

    @Test
    public void testSacar() {
        cliente = new Cliente();
        cliente.setSaldo(50.0);
        cliente.setId(1L);
        cliente.setDataNascimento(LocalDate.parse("1968-04-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        cliente.setNome("Francisco");
        cliente.setNumeroConta(8664);
        cliente.setEhPlanoExclusive(false);

        //clienteRepository.save(cliente);
        when(clienteService.sacar(1, "50.0")).thenReturn(cliente);

        assertNotNull(cliente);
        assertEquals(50, cliente.getSaldo());
    }
}