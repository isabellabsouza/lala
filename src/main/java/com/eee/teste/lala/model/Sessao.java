package com.eee.teste.lala.model;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Future;

@Entity
public class Sessao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Filme filme;

    @OneToOne(cascade = CascadeType.ALL)
    private Sala sala;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="sessao", fetch = FetchType.EAGER)
    private List<Ingresso> ingresso;

    @Future
    private LocalDateTime dataHora;

    public Sessao() {
    }

    public Sessao(Filme filme, Sala sala, LocalDateTime dataHora) {
        this.filme = filme;
        this.sala = sala;
        this.ingresso = new ArrayList<Ingresso>();
        this.dataHora = dataHora;
    }

    public void venderIngresso(Double valor, boolean meiaEntrada, Cliente cliente){
        if(this.ingresso.size() >= this.sala.getCapacidade())
            throw new RuntimeException("Sala cheia");
        
        this.ingresso.add(new Ingresso(valor, true, meiaEntrada, cliente, this));
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Ingresso> getIngresso() {
        return ingresso;
    }

    public void setIngresso(List<Ingresso> ingresso) {
        this.ingresso = ingresso;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    

    
}
