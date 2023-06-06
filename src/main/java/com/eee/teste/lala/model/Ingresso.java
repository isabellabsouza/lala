package com.eee.teste.lala.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Ingresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private double valor;

    @AssertTrue
    private boolean valido;

    @NotNull
    private boolean meiaEntrada;

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="codigo_sessao")
    private Sessao sessao;

    public Ingresso() {
    }

    public Ingresso(double valor, boolean valido, boolean meiaEntrada, Cliente cliente, Sessao sessao) {
        this.valor = valor;
        this.valido = valido;
        this.meiaEntrada = meiaEntrada;
        this.cliente = cliente;
        this.sessao = sessao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean isMeiaEntrada() {
        return meiaEntrada;
    }

    public void setMeiaEntrada(boolean meiaEntrada) {
        this.meiaEntrada = meiaEntrada;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    
    
}
