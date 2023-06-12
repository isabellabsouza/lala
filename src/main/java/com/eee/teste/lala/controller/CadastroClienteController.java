package com.eee.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.eee.teste.lala.model.Cliente;
import com.eee.teste.lala.service.ClienteService;

import jakarta.validation.Valid;

@Controller
public class CadastroClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastroCliente")
    public String cadastroCliente(Cliente cliente){
        return "CadastroCliente";
    }

    @PostMapping("/cadastroCliente")
    public String novo(@Valid Cliente cliente, BindingResult result) {

        if(result.hasFieldErrors()) {
            return "redirect:/cadastroCliente";
        }

        clienteService.save(cliente);

        return "redirect:/pesquisaCliente";
    }

}
