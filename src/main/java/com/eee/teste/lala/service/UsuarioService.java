package com.eee.teste.lala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eee.teste.lala.model.Usuario;
import com.eee.teste.lala.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void save(Usuario usuario){
        this.usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return this.usuarioRepository.findAll();
    }

    public Usuario findById(long id){
        return this.usuarioRepository.findById(id);
        
    }

    public void delete(Usuario usuario){
        this.usuarioRepository.delete(usuario);
    }
}
