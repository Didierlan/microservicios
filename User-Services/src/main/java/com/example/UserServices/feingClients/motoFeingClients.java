package com.example.UserServices.feingClients;

import com.example.UserServices.model.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "Moto-Service", url = "http://localhost:8003")
public interface motoFeingClients {

    @PostMapping("/moto")
    public Moto save(Moto moto);

    @GetMapping("/moto/users/{id}")
    public List<Moto> taerMotos(@PathVariable("id") Long id);


}
