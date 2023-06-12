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
import com.eee.teste.lala.model.Sala;
import com.eee.teste.lala.model.Sessao;
import com.eee.teste.lala.service.FilmeService;
import com.eee.teste.lala.service.SalaService;
import com.eee.teste.lala.service.SessaoService;

import jakarta.validation.Valid;

@Controller
public class PesquisaSessaoController {
    
    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private SalaService salaService;

    @GetMapping("/pesquisaSessao")
    public String pesquisaSessao(Model model){

        List<Sessao> sessoes = sessaoService.findAll();
        model.addAttribute("sessoes", sessoes);
        return "PesquisaSessao";
    }

    @GetMapping("/editarSessao/{id}")
    public String editar(@PathVariable(value="id") Long id, Model model) {

        List<Filme> filmes = filmeService.findAllAtivos();
        model.addAttribute("filmesTitulosAtivos", filmes);

        List<Sala> salas = salaService.findAll();
        model.addAttribute("salasNomes", salas);
        
        Sessao sessao = sessaoService.findById(id);
        model.addAttribute("sessao", sessao);
        return "AtualizaSessao";
    }

    //salva edicao
    @PostMapping("/editarSessao/{id}")
    public String editar(@PathVariable(value = "id") Long id, @Valid Sessao sessao, BindingResult result) {

        if(result.hasFieldErrors()) {
            return "redirect:/editarSessao/{id}";
        }
                
        sessaoService.save(sessao);
        return "redirect:/pesquisaSessao";
    }

    //exclui filme
    @GetMapping("excluirSessao/{id}")
    @CacheEvict(value = "sessoes", allEntries = true)
    public String excluir(@PathVariable(value = "id") Long id, Model model) {

        if(sessaoService.findById(id).getIngresso().size() > 0) {
            model.addAttribute("msg", "Não é possível excluir uma sessão com ingressos vendidos!");
            return "redirect:/pesquisaSessao";
        }

        Sessao sessao = sessaoService.findById(id);
                
        
        sessaoService.delete(sessao);
        return "redirect:/pesquisaSessao";
    }
}
