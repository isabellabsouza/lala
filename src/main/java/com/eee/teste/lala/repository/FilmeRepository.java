package com.eee.teste.lala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eee.teste.lala.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{
    
    Filme findById(long id);

    @Query(name = "Filme.findAllTitulos")
    List<String> findAllTitulos();

    @Query(name = "Filme.findAllAtivos")
    List<Filme> findAllAtivos();
}
