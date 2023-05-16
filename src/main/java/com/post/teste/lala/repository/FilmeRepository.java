package com.post.teste.lala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.post.teste.lala.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{
    
}
