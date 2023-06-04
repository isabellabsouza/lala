package com.eee.teste.lala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eee.teste.lala.model.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {

    Sessao findById(long id);

    
    
    
}
