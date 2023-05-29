package com.post.teste.lala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.teste.lala.model.Filme;
import com.post.teste.lala.repository.FilmeRepository;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public void save(Filme filme){
        this.filmeRepository.save(filme);
    }

    public List<Filme> findAll(){
        return this.filmeRepository.findAll();
    }
    
}
