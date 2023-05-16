package com.post.teste.lala.dto;

import java.time.LocalDate;

import com.post.teste.lala.model.ClassificacaoIndicativa;
import com.post.teste.lala.model.Filme;



public class FilmeDTO {
    
    private String titulo;
    private LocalDate dataLancamento;
    private boolean ativo;
    private ClassificacaoIndicativa classificacaoIndicativa;
    private int duracao;
    private String urlCartaz;

    public Filme toFilme(){
        Filme filme = new Filme();
        filme.setTitulo(this.titulo);
        filme.setDataLancamento(this.dataLancamento);
        filme.setAtivo(this.ativo);
        filme.setClassificacaoIndicativa(this.classificacaoIndicativa);
        filme.setDuracao(this.duracao);
        filme.setUrlCartaz(this.urlCartaz);
        return filme;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public ClassificacaoIndicativa getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getUrlCartaz() {
        return urlCartaz;
    }

    public void setUrlCartaz(String urlCartaz) {
        this.urlCartaz = urlCartaz;
    }

    
}
