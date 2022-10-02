package com.example.CarroService.service;

import com.example.CarroService.entity.Carro;
import com.example.CarroService.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;


    @Override
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    @Override
    public Carro findById(long id) {
        return carroRepository.findById(id).orElse(null);
    }

    @Override
    public Carro save(Carro carro) {
        return carroRepository.save(carro);
    }

    @Override
    public List<Carro> byUserId(Long id) {
        return carroRepository.findByUsuarioId(id);
    }
}
