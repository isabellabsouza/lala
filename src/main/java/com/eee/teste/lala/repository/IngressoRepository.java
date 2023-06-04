package com.eee.teste.lala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eee.teste.lala.model.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Long>{
    
}
