package com.post.teste.lala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.post.teste.lala.model.Filme;
import com.post.teste.lala.repository.FilmeRepository;


@Controller

public class PesquisaFilmeController {
    
    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("/pesquisaFilme")
    public String pesquisaFilme(Model model) {

        
        List<Filme> filmes = filmeRepository.findAll();
        model.addAttribute("filmes", filmes);
        return "PesquisaFilme";
    }
    
}
