package com.post.teste.lala.dto;

import com.post.teste.lala.model.Sala;



public class SalaDTO {
    
    private String nome;
    private int capacidade;

    public Sala toSala(){
        Sala sala = new Sala();
        sala.setNome(nome);
        sala.setCapacidade(capacidade);
        return sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    
   

    
}
