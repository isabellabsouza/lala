package com.eee.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eee.teste.lala.dto.FilmeDTO;
import com.eee.teste.lala.service.FilmeService;

import jakarta.validation.Valid;

@Controller
public class CadastroFilmeController {

    @Autowired
    private FilmeService filmeService;
    
    @GetMapping("/cadastroFilme")
    public String cadastroFilme(FilmeDTO filmeDTO) {
        return "CadastroFilme";
    }

    @PostMapping("/cadastroFilme")
    public String novo(@Valid FilmeDTO filmeDTO, BindingResult result) {

        
        if(result.hasFieldErrors()) {
            return "redirect:/cadastroFilme";
        }
        
        
        filmeService.save(filmeDTO.toFilme());

        return "redirect:/pesquisaFilme";
    }
}
