package com.post.teste.lala.model;

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

    @OneToOne
    
    private Cliente cliente;


    @ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="codigo_sessao")
    private Sessao sessao;
    
}
