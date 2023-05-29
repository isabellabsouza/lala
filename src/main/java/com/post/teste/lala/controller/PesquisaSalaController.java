package com.post.teste.lala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.post.teste.lala.model.Sala;
import com.post.teste.lala.service.SalaService;


@Controller

public class PesquisaSalaController {
    
    @Autowired
    private SalaService salaService;

    @GetMapping("/pesquisaSala")
    public String pesquisaSala(Model model) {

        
        List<Sala> salas = salaService.findAll();
        model.addAttribute("salas", salas);
        return "PesquisaSala";
    }
    
}
