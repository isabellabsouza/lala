package com.eee.teste.lala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eee.teste.lala.model.Usuario;
import com.eee.teste.lala.service.UsuarioService;

@Controller
public class PesquisaUsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/pesquisaUsuario")
    public String pesquisaFilme(Model model) {

        
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "PesquisaUsuario";
    }
}
