package com.post.teste.lala.model;


//import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Sessao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Filme filme;

    @OneToOne
    private Sala sala;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="sessao", fetch = FetchType.EAGER)
    private List<Ingresso> ingresso;

    
    //private Timestamp dataHora;
}
