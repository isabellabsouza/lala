package com.post.teste.lala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.post.teste.lala.model.Aluno;
import com.post.teste.lala.model.Status;
import com.post.teste.lala.repository.AlunoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    private AlunoRepository alunoRepository;


    @GetMapping()
    public String home(Model model) {
    
    	List<Aluno> alunos = alunoRepository.findAll();
        model.addAttribute("alunos", alunos);

        return "home";
    }

    //esse método recebe uma variável status que é passada na url, para acessar subpáginas
    @GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Aluno> alunos = alunoRepository.findByStatus(Status.valueOf(status.toUpperCase()));
		model.addAttribute("alunos", alunos);
		model.addAttribute("status", status);
		return "home"; 
	}
	
    //redireciona para a pagina home caso ocorra um erro, como por exemplo, o usuario tentar acessar uma pagina que nao existe
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
    
}
