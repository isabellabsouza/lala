package com.eee.teste.lala.dto;

import com.eee.teste.lala.model.Cliente;
import com.eee.teste.lala.model.Ingresso;
import com.eee.teste.lala.model.Sessao;

public class IngressoDTO {
    
    private double valor;
    private boolean valido;
    private boolean meiaEntrada;
    private Cliente cliente;
    private Sessao sessao;

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

    public Ingresso toIngresso(){
        Ingresso ingresso = new Ingresso();
        ingresso.setCliente(this.cliente);
        ingresso.setMeiaEntrada(this.meiaEntrada);
        ingresso.setSessao(this.sessao);
        ingresso.setValido(this.valido);
        ingresso.setValor(this.valor);
        return ingresso;
    }
}
