package com.example.UserServices.service;

import com.example.UserServices.entity.User;
import com.example.UserServices.feingClients.carroFeingClients;
import com.example.UserServices.feingClients.motoFeingClients;
import com.example.UserServices.model.Carro;
import com.example.UserServices.model.Moto;
import com.example.UserServices.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements  UserService{


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private userRepository userRepository;

    @Autowired
    private carroFeingClients carroFeingClients;

    @Autowired
    private motoFeingClients motoFeingClients;









    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }



    @Override
    public List<Carro> getVehiculos(Long id) {
        List<Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/users/" + id,List.class);
        return carros;
    }

    @Override
    public List<Moto> getMotos(Long id) {
        List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/users/" + id,List.class);
        return motos;
    }


    @Override
    public Moto saveMoto(Long id, Moto moto) {
        moto.setUsuarioId(id);
        Moto newMoto = motoFeingClients.save(moto);
        return newMoto;
    }

    public Carro saveCarro(Long usuarioId , Carro carro){
        carro.setUsuarioId(usuarioId);
        Carro newCarro = carroFeingClients.save(carro);
        return newCarro;
    }


    @Override
    public Map<String, Object> getUserAndVehicles(Long id) {
        Map<String, Object> result = new HashMap<>();

        User user = userRepository.findById(id).orElse(null);

        if(user == null){
            result.put("Usuario" , "El usuario no existe");
        }else {
            result.put("Usuario" , user);
        }

        List<Carro> carros = carroFeingClients.taerCarros(id);

        if(carros.isEmpty()){
            result.put("Carros" , "El usuario no tiene autos");
        }else {
            result.put("Carros" , carros);
        }

        List<Moto> motos = motoFeingClients.taerMotos(id);

        if(motos.isEmpty()){
            result.put("Motos" , "El usuario no tiene motos");
        }else {
            result.put("Motos" , motos);
        }

        return result;
    }






}
