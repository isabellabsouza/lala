package com.eee.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eee.teste.lala.model.Sala;
import com.eee.teste.lala.service.SalaService;

import jakarta.validation.Valid;

@Controller
public class CadastroSalaController {
    
    @Autowired
    private SalaService salaService;

    @GetMapping("/cadastroSala")
    public String cadastroSala(Sala sala) {
        return "CadastroSala";
    }

    @PostMapping("/cadastroSala")
    public String novo(@Valid Sala sala, BindingResult result) {

        
        if(result.hasFieldErrors()) {
            return "redirect:/cadastroSala";
        }
        
        salaService.save(sala);

        return "redirect:/pesquisaSala";
    }
}
