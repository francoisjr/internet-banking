package com.internet.banking.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo nome é obrigatório")
    private String nome;

    @NotNull(message = "Necessario informar se possui plano exclusive")
    private boolean ehPlanoExclusive;

    @NotNull(message = "Deve existir um valor prévio de saldo")
    private Double saldo;

    @NotNull(message = "É obrigatorio informar o numero da conta")
    private Integer numeroConta;

    @NotNull(message = "É obrigatorio informar a data de Nascimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

    public Cliente(Long id, String nome, boolean ehPlanoExclusive, Double saldo, Integer numeroConta, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.ehPlanoExclusive = ehPlanoExclusive;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.dataNascimento = dataNascimento;
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEhPlanoExclusive() {
        return ehPlanoExclusive;
    }

    public void setEhPlanoExclusive(boolean ehPlanoExclusive) {
        this.ehPlanoExclusive = ehPlanoExclusive;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ehPlanoExclusive=" + ehPlanoExclusive +
                ", saldo=" + saldo +
                ", numeroConta=" + numeroConta +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
