package com.example.UserServices.feingClients;

import com.example.UserServices.model.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "Carro-Service")
public interface carroFeingClients {

    @PostMapping("/carro")
    public Carro save(@RequestBody Carro carro);

    @GetMapping("/carro/users/{id}")
    public List<Carro> taerCarros(@PathVariable("id") Long id);
}
