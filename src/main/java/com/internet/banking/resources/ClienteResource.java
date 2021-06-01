package com.internet.banking.resources;

import com.internet.banking.entities.Cliente;
import com.internet.banking.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Api(tags = {"API - Controle de Clientes"})
@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Este Endpoint tem como objetivo listar todos os clientes cadastrados")
    @GetMapping
    public ResponseEntity<Page<Cliente>> findAll(Pageable pageable) {
        Page<Cliente> list = clienteService.findAll(pageable);
        return ResponseEntity.ok().body(list);
    }

    @ApiOperation(value = "Este Endpoint tem como objetivo salvar um cliente preenchendos os campos obrigatórios")
    @PostMapping
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        Cliente obj = clienteService.save(cliente);

        URI location = URI.create("/clientes/");
        return ResponseEntity.created(location).body(obj);
    }

    @ApiOperation(value = "Este Endpoint tem como objetivo sacar um determinado valor de um cliente em especifico")
    @PatchMapping(value = "{clientId}/sacar/{valor}")
    public ResponseEntity<Cliente> sacar(@PathVariable Integer clientId, @PathVariable String valor) {
        Cliente c = clienteService.sacar(clientId, valor);
        return ResponseEntity.ok().body(c);
    }

    @ApiOperation(value = "Este Endpoint tem como objetivo efetuar um depósito informando o valor e o ID do cliente previamente cadastrado")
    @PatchMapping(value = "{clientId}/depositar/{valor}")
    public ResponseEntity<Cliente> depositar(@PathVariable Integer clientId, @PathVariable String valor) {
        Cliente cliente = clienteService.depositar(clientId, valor);
        return ResponseEntity.ok().body(cliente);
    }
}