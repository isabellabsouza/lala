package com.post.teste.lala.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.post.teste.lala.model.Aluno;
import com.post.teste.lala.model.Status;

import jakarta.validation.constraints.NotBlank;

//essa classe transforma os dados inseridos no formulario html em um objeto do tipo Aluno
public class RequisicaoNovoAluno {
    
    //atributos devem ter o mesmo nome dos campos "name" do formulario
    @NotBlank
    private String nomeAluno;
    private LocalDate dataNascimento;
    private String email;
    private String descricao;
    private String urlImagem;
    private Status status;

    // Getters and Setters
    public String getNomeAluno() {
        return nomeAluno;
    }
    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getUrlImagem() {
        return urlImagem;
    }
    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
    public Status getStatus() {

        return status;
    }
    public void setStatus(String status) {
        
        if(status.equals("APROVADO")) {
            this.status = Status.APROVADO;
        } else if(status.equals("REPROVADO")) {
            this.status = Status.REPROVADO;
        } else {
            this.status = Status.EM_ANALISE;
        }
    }    

    //método que faz a transformação
    public Aluno toAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.nomeAluno);
        aluno.setDataNascimento(this.dataNascimento);
        aluno.setEmail(this.email);
        aluno.setDescricao(this.descricao);
        aluno.setUrlImagem(this.urlImagem);
        aluno.setStatus(this.status);
        return aluno;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {

        //transforma a data de nascimento para LocalDate
        this.dataNascimento = dataNascimento.isEmpty() ? null : LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    }

}
