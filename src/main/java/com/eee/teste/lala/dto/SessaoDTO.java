package com.eee.teste.lala.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.eee.teste.lala.model.Filme;
import com.eee.teste.lala.model.Ingresso;
import com.eee.teste.lala.model.Sala;
import com.eee.teste.lala.model.Sessao;

public class SessaoDTO {
    
    private LocalDateTime dataHora;
    private Filme filme;
    private Sala sala;
    private List<Ingresso> ingresso;

    public Sessao toSessao(){
        Sessao sessao = new Sessao();
        sessao.setDataHora(this.dataHora);
        sessao.setFilme(this.filme);
        sessao.setSala(this.sala);
        sessao.setIngresso(this.ingresso);
        return sessao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
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

    
}
