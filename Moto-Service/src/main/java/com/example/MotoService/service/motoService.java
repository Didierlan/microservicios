package com.example.MotoService.service;

import com.example.MotoService.entity.Moto;

import java.util.List;

public interface motoService {

    List<Moto> findAll();

    Moto findById(long id);

    Moto save(Moto moto);

    List<Moto> byUserCar(Long id);
}
