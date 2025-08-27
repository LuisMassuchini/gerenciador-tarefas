package com.massuchini.gerenciador_tarefas.service;

import com.massuchini.gerenciador_tarefas.entity.Tarefa;
import com.massuchini.gerenciador_tarefas.repository.TarefaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public  Tarefa buscarPorId(Long id) {
        Optional<Tarefa> tarefaOptional = tarefaRespository.findById(id);

        if(tarefaOptional.isPresent()) {
            return tarefaOptional.get();
        } else {
            throw new RuntimeException("Tarefa não encontrada com id: " + id);
        }
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefaComNovosDados) {
        Tarefa tarefaExistente = this.buscarPorId(id);

        tarefaExistente.setTitulo(tarefaComNovosDados.getTitulo());
        tarefaExistente.setDescricao(tarefaComNovosDados.getDescricao());
        tarefaExistente.setStatus(tarefaComNovosDados.getStatus());

        return tarefaRespository.save(tarefaExistente);
    }

    public void deletarTarefa(Long id) {
        Tarefa tarefa = buscarPorId(id);
        tarefaRespository.delete(tarefa);
    }
}
