package com.eee.teste.lala.dto;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import com.eee.teste.lala.model.Filme;
import com.eee.teste.lala.model.Ingresso;
import com.eee.teste.lala.model.Sala;
import com.eee.teste.lala.model.Sessao;

public class SessaoDTO {
    
    private Timestamp dataHora;
    private Filme filme;
    private Sala sala;
    private List<Ingresso> ingresso;
    private LocalDate data;
    private Time hora;

    public Sessao toSessao(){
        Sessao sessao = new Sessao();
        sessao.setDataHora(this.dataHora);
        sessao.setData(this.data);
        sessao.setHora(this.hora);
        sessao.setFilme(this.filme);
        sessao.setSala(this.sala);
        sessao.setIngresso(this.ingresso);
        return sessao;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
}
