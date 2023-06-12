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

import com.eee.teste.lala.model.Filme;
import com.eee.teste.lala.service.FilmeService;

import jakarta.validation.Valid;


@Controller

public class PesquisaFilmeController {
    
    @Autowired
    private FilmeService filmeService;

    @GetMapping("/pesquisaFilme")
    public String pesquisaFilme(Model model) {

        
        List<Filme> filmes = filmeService.findAll();
        model.addAttribute("filmes", filmes);
        return "PesquisaFilme";
    }

    //acessa formulario de edicao

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable(value="id") Long id, Model model) {

        Filme filme = filmeService.findById(id);
        model.addAttribute("filme", filme);
        return "AtualizaFilme";
    }

    //salva edicao
    @PostMapping("/editar/{id}")
    public String editar(@PathVariable(name = "id") Long id, @Valid Filme filme, BindingResult result) {

        if(result.hasFieldErrors()) {
            return "redirect:/editar/{id}";
        }
        
        filmeService.save(filme);
        return "redirect:/pesquisaFilme";
    }

    //exclui filme
    @GetMapping("excluir/{id}")
    @CacheEvict(value = "filmes", allEntries = true)
    public String excluir(@PathVariable(name = "id") Long id, Model model) {

        Filme filme = filmeService.findById(id);
                
        
        filmeService.delete(filme);
        return "redirect:/pesquisaFilme";
    }
    
}
