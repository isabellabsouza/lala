package com.eee.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eee.teste.lala.dto.IngressoDTO;
import com.eee.teste.lala.model.Ingresso;
import com.eee.teste.lala.service.IngressoService;

import jakarta.validation.Valid;

@Controller
public class CadastroIngressoController {
    
    @Autowired
    private IngressoService ingressoService;

    @GetMapping("/cadastroIngresso")
    public String cadastroIngresso(IngressoDTO ingressoDTO){
        return "CadastroIngresso";
    }

    @PostMapping("/cadastroIngresso")
    public String novo(@Valid IngressoDTO ingressoDTO, BindingResult result){

        Ingresso ingresso = ingressoDTO.toIngresso();
        ingressoService.save(ingresso);

        return "redirect:/pesquisaIngresso";
    }

}
