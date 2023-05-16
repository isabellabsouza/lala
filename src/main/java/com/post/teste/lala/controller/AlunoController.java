package com.post.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.post.teste.lala.dto.RequisicaoNovoAluno;
import com.post.teste.lala.model.Aluno;
import com.post.teste.lala.repository.AlunoRepository;

import jakarta.validation.Valid;

//a anotação @Controller indica que a classe vai receber as requisições do usuário
@Controller
//a anotação @RequestMapping indica o caminho que a classe vai receber as requisições do usuário
@RequestMapping("aluno")
public class AlunoController {
    
    //a anotação @Autowired indica que o Spring vai injetar a dependência, ou seja, vai criar o objeto
    @Autowired
    private AlunoRepository alunoRepository;
    
    //a anotação @GetMapping indica que o método vai receber requisições do tipo GET
    @GetMapping("formulario")
    public String formulario(RequisicaoNovoAluno requisicao) {
        return "aluno/formulario";
    }

    //a anotação @PostMapping indica que o método vai receber requisições do tipo POST
    @PostMapping("novo")
    //a anotacao @Valid faz a validacao automatica do objeto requisicao
    public String novo(@Valid RequisicaoNovoAluno requisicao, BindingResult result) {

        if(result.hasErrors()) {
            return "aluno/formulario";
        }
        

        //converter requisicao de novo aluno para objeto aluno
        Aluno aluno = requisicao.toAluno();
        //o método save() salva o objeto no banco de dados
        //é nativo do Spring Data JPA
        alunoRepository.save(aluno);

        return "redirect:/home";
    }
}
