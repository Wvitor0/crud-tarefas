package com.example.tarefaCRUD.repository;

import com.example.tarefaCRUD.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
