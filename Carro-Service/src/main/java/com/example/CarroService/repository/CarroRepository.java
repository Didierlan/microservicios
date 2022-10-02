package com.example.CarroService.repository;

import com.example.CarroService.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Long> {

    List<Carro> findByUsuarioId(Long IdUser);
}
