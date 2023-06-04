package com.eee.teste.lala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eee.teste.lala.model.Ingresso;
import com.eee.teste.lala.service.IngressoService;

@Controller
public class PesquisaIngressoController {
    
    @Autowired
    private IngressoService ingressoService;

    @GetMapping("/pesquisaIngresso")
    public String pesquisaIngresso(Model model){

        List<Ingresso> ingressos = ingressoService.findAll();
        model.addAttribute("ingressos", ingressos);
        return "PesquisaIngresso";
    }
   
}