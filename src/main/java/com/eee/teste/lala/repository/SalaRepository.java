package com.eee.teste.lala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eee.teste.lala.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{
    
    Sala findById(long id);

    @Query(name = "Sala.findAllNomes")
    List<String> findAllNomes();
    
}
