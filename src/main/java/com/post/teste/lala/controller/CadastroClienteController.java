package com.post.teste.lala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.post.teste.lala.dto.ClienteDTO;
import com.post.teste.lala.model.Cliente;
import com.post.teste.lala.service.ClienteService;

import jakarta.validation.Valid;

@Controller
public class CadastroClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cadastroCliente")
    public String cadastroCliente(ClienteDTO clienteDTO){
        return "CadastroCliente";
    }

    @PostMapping("/cadastroCliente")
    public String novo(@Valid ClienteDTO clienteDTO, BindingResult result) {

        Cliente cliente = clienteDTO.toCliente();
        clienteService.save(cliente);

        return "redirect:/pesquisaCliente";
    }

}
