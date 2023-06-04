package com.eee.teste.lala.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eee.teste.lala.model.Sessao;
import com.eee.teste.lala.repository.SessaoRepository;

@Service
public class SessaoService {
    
    @Autowired
    private SessaoRepository sessaoRepository;

    public void save(Sessao sessao){
        this.sessaoRepository.save(sessao);
    }

    public List<Sessao> findAll(){
        return this.sessaoRepository.findAll();
    }

    public Sessao findById(long id){
        
        return this.sessaoRepository.findById(id);
        
    }

    public void delete(Sessao sessao){
        this.sessaoRepository.delete(sessao);
    }

    
}
