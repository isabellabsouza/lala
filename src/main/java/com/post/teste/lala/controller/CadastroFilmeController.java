package com.post.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.post.teste.lala.dto.FilmeDTO;
import com.post.teste.lala.model.Filme;
import com.post.teste.lala.service.FilmeService;

import jakarta.validation.Valid;

@Controller
public class CadastroFilmeController {
    /*
    @Autowired
    private FilmeRepository filmeRepository;*/

    @Autowired
    private FilmeService filmeService;
    
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
        filmeService.save(filme);

        return "redirect:/pesquisaFilme";
    }
}
