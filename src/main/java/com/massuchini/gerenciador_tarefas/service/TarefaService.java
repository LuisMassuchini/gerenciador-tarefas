package com.massuchini.gerenciador_tarefas.service;

import com.massuchini.gerenciador_tarefas.entity.Tarefa;
import com.massuchini.gerenciador_tarefas.repository.TarefaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRespository tarefaRespository;

    public List<Tarefa> listarTodas() {
        return tarefaRespository.findAll();
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRespository.save(tarefa);
    }

}
