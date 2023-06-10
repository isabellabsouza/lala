package com.eee.teste.lala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eee.teste.lala.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Usuario findById(long id);

    // @Query("SELECT authority FROM authorities WHERE username = 'user'")
    // String findAuthorityByUsername(String username);

   
    
}
