package com.eee.teste.lala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eee.teste.lala.model.Aluno;
import com.eee.teste.lala.model.Status;

//a classe com a anotação @Repository é equivalente à DAO, responsável pelo acesso ao banco de dados
@Repository

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    //o metodo findByStatus(), aplicado pelo spring data, é equivalente à um SELECT * FROM Aluno WHERE status = ?
    List<Aluno> findByStatus(Status status);
    
    //o metodo findAll(), aplicado pelo spring data, é equivalente à um SELECT * FROM Aluno
    //quando implementamos a interface JpaRepository, o spring data já implementa esse método pra gente
    //public List<Aluno> findAll();


    //o metodo save(), aplicado pelo spring data, é equivalente à um INSERT INTO Aluno
}
