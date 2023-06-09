package com.eee.teste.lala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.eee.teste.lala.model.Cliente;
import com.eee.teste.lala.model.Ingresso;
import com.eee.teste.lala.model.Sessao;
import com.eee.teste.lala.service.ClienteService;
import com.eee.teste.lala.service.IngressoService;
import com.eee.teste.lala.service.SessaoService;

import jakarta.validation.Valid;

@Controller
public class VendaIngressoController {

    @Autowired
    private IngressoService ingressoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SessaoService sessaoService;

    private Sessao sessaoSelecionada;

    //@PathVariable(value="sessao_id") Long id

    @GetMapping("/vendaIngresso/{id}")
    public String cadastroIngresso(Ingresso ingresso, Model model, @PathVariable(value="id") long id){

        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);

        sessaoSelecionada = sessaoService.findById(id);
        return "VendaIngresso";
    }

    @PostMapping("/vendaIngresso/{id}")
    public String novo(@Valid Ingresso ingresso, BindingResult result){

        //sessaoSelecionada = sessaoService.findById(id);
        ingresso.setSessao(sessaoSelecionada);
        // System.out.println("*******sessaoSelecionada=" + sessaoSelecionada);
        ingressoService.save(ingresso);

        return "redirect:/pesquisaIngresso";
    }

}
