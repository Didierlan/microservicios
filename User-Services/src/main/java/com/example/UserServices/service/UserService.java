package com.example.UserServices.service;

import com.example.UserServices.entity.User;
import com.example.UserServices.model.Carro;
import com.example.UserServices.model.Moto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface UserService {


    Map<String,Object> getUserAndVehicles(Long id);
    Moto saveMoto(Long id , Moto moto);
    Carro saveCarro(Long usuarioId , Carro carro);
    List<Carro> getVehiculos(Long id);

    List<Moto> getMotos(Long id);

    List<User> findAll();

    User findById(long id);

    User save(User user);

}
