package com.internet.banking.services;

import com.internet.banking.entities.Transacao;
import com.internet.banking.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Page<Transacao> findByData(LocalDate data, Pageable pageable) {
        Page<Transacao> transacaoList = transacaoRepository.findByData(data, pageable);
        return transacaoList;
    }
}
