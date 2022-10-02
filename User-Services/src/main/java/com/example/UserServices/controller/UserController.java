package com.example.UserServices.controller;

import com.example.UserServices.entity.User;
import com.example.UserServices.model.Carro;
import com.example.UserServices.model.Moto;
import com.example.UserServices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") long id){

        User user = userService.findById(id);
        if(user == null){
            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(user);

    }


    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User user1 = userService.save(user);
        return ResponseEntity.ok(user1);


    }

    @GetMapping("/carro/{usuarioId}")
    public ResponseEntity<List<Carro>> listarCarros(@PathVariable("usuarioId") Long id){
        User user = userService.findById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }

        List<Carro> carros = userService.getVehiculos(id);

        return ResponseEntity.ok(carros);

    }


    @GetMapping("/moto/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotos(@PathVariable("usuarioId") Long id){
        User user = userService.findById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }

        List<Moto> motos = userService.getMotos(id);

        return ResponseEntity.ok(motos);

    }

    @PostMapping("/carro/{id}")
    public ResponseEntity<Carro> guardarCarro(@PathVariable("id") Long id, @RequestBody Carro carro){

        Carro newCarro = userService.saveCarro(id,carro);
        return ResponseEntity.ok(newCarro);

    }


    @PostMapping("/moto/{id}")
    public ResponseEntity<Moto> guardarMoto(@PathVariable("id") Long id, @RequestBody Moto moto){

        Moto newMoto = userService.saveMoto(id,moto);
        return ResponseEntity.ok(newMoto);

    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Map<String,Object>> getAllUserAndVehicles(@PathVariable("id") Long id){

        Map<String,Object> todo = userService.getUserAndVehicles(id);
        return ResponseEntity.ok(todo);

    }

}
