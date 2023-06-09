package com.eee.teste.lala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eee.teste.lala.model.Sala;
import com.eee.teste.lala.service.SalaService;

import jakarta.validation.Valid;


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

    @GetMapping("/editarSala/{id}")
    public String editarSala(@PathVariable(value = "id") Long id, Model model) {

        Sala sala = salaService.findById(id);
        model.addAttribute("sala", sala);
        return "AtualizaSala";
    }

    @PostMapping("/editarSala/{id}")
    public String editarSala(@PathVariable(value = "id") Long id, @Valid Sala sala, BindingResult result) {

        if(result.hasFieldErrors()) {
            return "redirect:/editarSala/{id}";
        }

        sala = salaService.findById(id);

        salaService.save(sala);
        return "redirect:/pesquisaSala";
        
    }

    @GetMapping("excluirSala/{id}")
    @CacheEvict(value = "salas", allEntries = true)
    public String excluirSala(@PathVariable(name = "id") Long id, Model model) {

        Sala sala = salaService.findById(id);
                
        
        salaService.delete(sala);
        return "redirect:/pesquisaSala";
    }
    
}
