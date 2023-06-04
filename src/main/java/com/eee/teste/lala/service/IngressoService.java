package com.eee.teste.lala.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eee.teste.lala.model.Ingresso;
import com.eee.teste.lala.repository.IngressoRepository;

@Service
public class IngressoService {
    
    @Autowired
    private IngressoRepository ingressoRepository;

    public void save(Ingresso ingresso){
        this.ingressoRepository.save(ingresso);
    }

    public List<Ingresso> findAll(){
        return this.ingressoRepository.findAll();
    }

    
}
