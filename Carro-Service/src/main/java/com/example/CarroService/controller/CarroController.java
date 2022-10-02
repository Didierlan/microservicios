package com.example.CarroService.controller;

import com.example.CarroService.entity.Carro;
import com.example.CarroService.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;


    @GetMapping
    public ResponseEntity<List<Carro>> findAll(){

        List<Carro> carros = carroService.findAll();
        if(carros.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> findById(@PathVariable("id") Long id){

        Carro carro = carroService.findById(id);
        if(carro == null){
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(carro);

    }


    @PostMapping
    public ResponseEntity<Carro> save(@RequestBody Carro carro){
        Carro carro1 =carroService.save(carro);
        return ResponseEntity.ok(carro1);


    }


    @GetMapping("/users/{id}")
    public ResponseEntity<List<Carro>> listarCarrosPorUserId(@PathVariable("id") Long id){

        List<Carro> carros = carroService.byUserId(id);
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(carros);
    }


}
