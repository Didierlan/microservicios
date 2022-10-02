package com.example.MotoService.service;

import com.example.MotoService.entity.Moto;
import com.example.MotoService.repository.motoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class motoServiceImpl implements motoService{

    @Autowired
    private motoRepository motoRepository;

    @Override
    public List<Moto> findAll() {
        return motoRepository.findAll();
    }

    @Override
    public Moto findById(long id) {
        return motoRepository.findById(id).orElse(null);
    }

    @Override
    public Moto save(Moto moto) {
        return motoRepository.save(moto);
    }

    @Override
    public List<Moto> byUserCar(Long id) {
        return motoRepository.findByUsuarioId(id);
    }
}
