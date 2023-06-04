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

import com.eee.teste.lala.dto.SessaoDTO;
import com.eee.teste.lala.model.Sessao;
import com.eee.teste.lala.service.SessaoService;

import jakarta.validation.Valid;

@Controller
public class PesquisaSessaoController {
    
    @Autowired
    private SessaoService sessaoService;

    @GetMapping("/pesquisaSessao")
    public String pesquisaSessao(Model model){

        List<Sessao> sessoes = sessaoService.findAll();
        model.addAttribute("sessoes", sessoes);
        return "PesquisaSessao";
    }

    @GetMapping("/editarSessao/{id}")
    public String editar(@PathVariable(value="id") Long id, Model model) {

        Sessao sessao = sessaoService.findById(id);
        model.addAttribute("sessao", sessao);
        return "AtualizaFilme";
    }

    //salva edicao
    @PostMapping("/editarSessao/{id}")
    public String editar(@PathVariable(value = "id") Long id, @Valid SessaoDTO sessaoDTO, BindingResult result) {

        if(result.hasFieldErrors()) {
            return "redirect:/editarSessao/{id}";
        }
        
        Sessao sessao = sessaoService.findById(id);
        sessao.setFilme(sessaoDTO.getFilme());
        sessao.setSala(sessaoDTO.getSala());
        //sessao.setDataHora(sessaoDTO.getDataHora());
        sessao.setIngresso(sessaoDTO.getIngresso());
        
        //filmeDTO.toFilme();
        sessaoService.save(sessao);
        return "redirect:/pesquisaSessao";
    }

    //exclui filme
    @GetMapping("excluirSessao/{id}")
    @CacheEvict(value = "sessoes", allEntries = true)
    public String excluir(@PathVariable(value = "id") Long id, Model model) {

        Sessao sessao = sessaoService.findById(id);
                
        
        sessaoService.delete(sessao);
        return "redirect:/pesquisaSessao";
    }
}
