package com.post.teste.lala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.teste.lala.model.Sala;
import com.post.teste.lala.repository.SalaRepository;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public void save(Sala sala){
        this.salaRepository.save(sala);
    }

    public List<Sala> findAll(){
        return this.salaRepository.findAll();
    }
    
    /* 
    public Filme findById(Long id){
        return this.salaRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        this.filmeRepository.deleteById(id);
    }

    public void deleteAll(){
        this.filmeRepository.deleteAll();
    }

    public void delete(Filme filme){
        this.filmeRepository.delete(filme);
    }*/
    
    
}
