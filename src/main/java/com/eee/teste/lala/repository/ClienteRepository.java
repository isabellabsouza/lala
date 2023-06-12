package com.eee.teste.lala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eee.teste.lala.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    Cliente findById(long id);
    
}
