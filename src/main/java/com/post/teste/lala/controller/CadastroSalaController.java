package com.post.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.post.teste.lala.dto.SalaDTO;
import com.post.teste.lala.model.Sala;
import com.post.teste.lala.service.SalaService;

import jakarta.validation.Valid;

@Controller
public class CadastroSalaController {
    
    @Autowired
    private SalaService salaService;

    @GetMapping("/cadastroSala")
    public String cadastroSala(SalaDTO salaDTO) {
        return "CadastroSala";
    }

    @PostMapping("/cadastroSala")
    public String novo(@Valid SalaDTO salaDTO, BindingResult result) {

        /*
        if(result.hasErrors()) {
            return "aluno/formulario";
        }*/
        
        Sala sala = salaDTO.toSala();
        salaService.save(sala);

        return "redirect:/pesquisaSala";
    }
}
