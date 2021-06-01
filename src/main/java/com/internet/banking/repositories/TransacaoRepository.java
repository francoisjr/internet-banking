package com.internet.banking.repositories;

import com.internet.banking.entities.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = "SELECT t from Transacao t WHERE t.dataTransacao = ?1")
    Page<Transacao> findByData(LocalDate data, Pageable pageable);
}