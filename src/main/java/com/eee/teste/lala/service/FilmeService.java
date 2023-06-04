package com.eee.teste.lala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eee.teste.lala.model.Filme;
import com.eee.teste.lala.repository.FilmeRepository;

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

    public Filme findById(long id){
        return this.filmeRepository.findById(id);
        
    }

    public void delete(Filme filme){
        this.filmeRepository.delete(filme);
    }

    public List<String> findAllTitulos(){
        return this.filmeRepository.findAllTitulos();
    }
    
    public List<Filme> findAllAtivos(){
        return this.filmeRepository.findAllAtivos();
    }
    
}
