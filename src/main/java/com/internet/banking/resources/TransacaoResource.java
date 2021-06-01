package com.internet.banking.resources;

import com.internet.banking.entities.Transacao;
import com.internet.banking.services.TransacaoService;
import com.internet.banking.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"API - Controle de Transações bancarias"})
@RestController
@RequestMapping(value = "/transacao")
public class TransacaoResource {

    @Autowired
    private TransacaoService transacaoService;

    @ApiOperation(value = "Este Endpoint tem como objetivo listar todos as transações (Saque e Deposito) efetuadas em uma determinada data informada")
    @GetMapping(value = "/consultar-historico/{data}")
    public ResponseEntity<Page<Transacao>> findByData(@PathVariable String data, Pageable pageable) {
        Page<Transacao> transacaoList = transacaoService.findByData(Util.parseData(data), pageable);
        return ResponseEntity.ok().body(transacaoList);
    }
}
