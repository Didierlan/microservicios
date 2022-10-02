package com.example.CarroService.service;



import com.example.CarroService.entity.Carro;

import java.util.List;


public interface CarroService {

    List<Carro> findAll();

    Carro findById(long id);

    Carro save(Carro carro);

    List<Carro> byUserId(Long id);

}
