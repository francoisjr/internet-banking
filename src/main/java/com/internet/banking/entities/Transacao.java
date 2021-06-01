package com.internet.banking.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.internet.banking.entities.enums.TipoTransacao;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_transacao")
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tipoTransacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataTransacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Transacao(Long id, TipoTransacao tipoTransacao, LocalDate dataTransacao, Cliente c) {
        this.id = id;
        setTipoTransacao(tipoTransacao);
        this.dataTransacao = dataTransacao;
        this.cliente = c;
    }


    public Transacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTransacao getTipoTransacao() {
        return TipoTransacao.valueOf(tipoTransacao);

    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        if (tipoTransacao != null) {
            this.tipoTransacao = tipoTransacao.getCode();
        }
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDate dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", tipoTransacao=" + tipoTransacao +
                ", dataTransacao=" + dataTransacao +
                '}';
    }
}
