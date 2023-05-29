package com.post.teste.lala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.teste.lala.model.Cliente;
import com.post.teste.lala.repository.ClienteRepository;

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
    
}
