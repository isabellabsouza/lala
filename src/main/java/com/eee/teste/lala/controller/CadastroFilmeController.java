package com.eee.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eee.teste.lala.model.Filme;
import com.eee.teste.lala.service.FilmeService;

import jakarta.validation.Valid;

@Controller
public class CadastroFilmeController {

    @Autowired
    private FilmeService filmeService;
    
    @GetMapping("/cadastroFilme")
    public String cadastroFilme(Filme filme) {
        return "CadastroFilme";
    }

    @PostMapping("/cadastroFilme")
    public String novo(@Valid Filme filme, BindingResult result) {

        
        if(result.hasFieldErrors()) {
            return "redirect:/cadastroFilme";
        }
        
        
        filmeService.save(filme);

        return "redirect:/pesquisaFilme";
    }
}
