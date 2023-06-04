package com.eee.teste.lala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eee.teste.lala.model.Cliente;
import com.eee.teste.lala.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void save(Cliente cliente){
        this.clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }

    public Cliente findById(long id){
        Cliente c = this.clienteRepository.findById(id);
        // return new ClienteDTO(c);
        return c;
        
    }

    public void delete(Cliente cliente){
        this.clienteRepository.delete(cliente);
    }

    /*public Filme findById(long id){
        Filme f = this.filmeRepository.findById(id);
        // return new FilmeDTO(f);
        return f;
        
    }

    public void delete(Filme filme){
        this.filmeRepository.delete(filme);
    } */
    
}
