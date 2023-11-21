package com.example.tarefaCRUD.service;

import com.example.tarefaCRUD.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tarefaCRUD.models.Tarefa;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }
    public Optional<Tarefa> obterTarefaPorId(Long id) {
        return tarefaRepository.findById(id);
    }
    public Tarefa create(Tarefa tarefa) {
        // Lógica de validação, se necessário
        return tarefaRepository.save(tarefa);
    }

    public Tarefa update(Long id, Tarefa tarefaAtualizada) {
        Tarefa tarefaExistente = tarefaRepository.findById(id).orElse(null);

        if (tarefaExistente != null) {
            tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
            tarefaExistente.setFeito(tarefaAtualizada.isFeito());

            return tarefaRepository.save(tarefaExistente);
        } else {
            // Trate o caso em que a tarefa com o ID fornecido não foi encontrada
            return null;
        }
    }
    public void delete(Long id) {
        tarefaRepository.deleteById(id);
    }
}
