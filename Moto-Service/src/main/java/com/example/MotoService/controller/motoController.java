package com.example.MotoService.controller;


import com.example.MotoService.entity.Moto;
import com.example.MotoService.service.motoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class motoController {

    @Autowired
    private motoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> findAll(){

        List<Moto> motos = motoService.findAll();
        if(motos.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> findById(@PathVariable("id") long id){

        Moto moto = motoService.findById(id);
        if(moto == null){
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(moto);

    }


    @PostMapping
    public ResponseEntity<Moto> save(@RequestBody Moto moto){
        Moto moto1 =motoService.save(moto);
        return ResponseEntity.ok(moto1);


    }


    @GetMapping("/users/{id_user}")
    public ResponseEntity<List<Moto>> listarMotosPorUserIs(@PathVariable("id_user") Long id){

        List<Moto> motos = motoService.byUserCar(id);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }


}
