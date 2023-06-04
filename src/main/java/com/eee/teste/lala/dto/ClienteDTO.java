package com.eee.teste.lala.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.eee.teste.lala.model.Cliente;

public class ClienteDTO {
    
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public Cliente toCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setCpf(this.cpf);
        cliente.setDataNascimento(this.dataNascimento);
        return cliente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {

        //transforma a data de nascimento para LocalDate
        this.dataNascimento = dataNascimento.isEmpty() ? null : LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

}
