package com.post.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.post.teste.lala.dto.FilmeDTO;
import com.post.teste.lala.model.Filme;
import com.post.teste.lala.repository.FilmeRepository;

import jakarta.validation.Valid;

@Controller
public class CadastroFilmeController {
    
    @Autowired
    private FilmeRepository filmeRepository;
    
    @GetMapping("/cadastroFilme")
    public String cadastroFilme(FilmeDTO filmeDTO) {
        return "CadastroFilme";
    }

    @PostMapping("/cadastroFilme")
    public String novo(@Valid FilmeDTO filmeDTO, BindingResult result) {

        /*
        if(result.hasErrors()) {
            return "aluno/formulario";
        }*/
        
        Filme filme = filmeDTO.toFilme();
        filmeRepository.save(filme);

        return "redirect:/PesquisaFilme";
    }
}
