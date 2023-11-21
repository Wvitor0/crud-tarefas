package com.example.tarefaCRUD.clients;

import com.example.tarefaCRUD.models.Tarefa;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component("MyRestClient")
public class MyRestClientImpl implements MyRestClient {
    private String baseAddress = "http://localhost:8080/itemManager";
    @Override
    public void doRestCalls() {
        RestTemplate template = new RestTemplate();
        Tarefa tarefa4 = template.getForObject(baseAddress + "/4", Tarefa.class);
        ParameterizedTypeReference<List<Tarefa>> responseType = new ParameterizedTypeReference<List<Tarefa>>() {};
        ResponseEntity<List<Tarefa>> response = template.exchange(baseAddress + "/items",
                HttpMethod.GET,
                null,
                responseType);
        template.delete(baseAddress + "/4");
    }
}

