package com.post.teste.lala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.post.teste.lala.model.Cliente;
import com.post.teste.lala.service.ClienteService;

@Controller
public class PesquisaClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/pesquisaCliente")
    public String pesquisaCliente(Model model) {

        List<Cliente> clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "PesquisaCliente";
    }
}
