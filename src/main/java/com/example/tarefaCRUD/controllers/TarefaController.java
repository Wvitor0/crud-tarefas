package com.example.tarefaCRUD.controllers;

import com.example.tarefaCRUD.models.Tarefa;
import com.example.tarefaCRUD.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;
    @GetMapping
    public List<Tarefa> listarTarefas(){
        return tarefaService.listarTarefas();
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Optional<Tarefa>> getItem(@PathVariable Long id) {

        Optional<Tarefa> result = tarefaService.obterTarefaPorId(id);

        if (result == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(result);
    }

    @PostMapping(consumes = {"Application/json", "Application/json"},
            produces = {"Application/json", "Application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa){
        tarefaService.create(tarefa);
        return tarefa;
    }
    @PutMapping(value = "/{id}", consumes = {"Application/json", "Application/json"})
    public void atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        tarefaService.update(id, tarefaAtualizada);
    }
    @DeleteMapping(value = "/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.delete(id);
    }
}
