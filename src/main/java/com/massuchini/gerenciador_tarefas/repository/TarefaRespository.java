package com.massuchini.gerenciador_tarefas.repository;


import com.massuchini.gerenciador_tarefas.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRespository extends JpaRepository<Tarefa, Long> {
}
