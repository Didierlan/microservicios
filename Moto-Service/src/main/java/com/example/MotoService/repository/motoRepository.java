package com.example.MotoService.repository;

import com.example.MotoService.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface motoRepository extends JpaRepository<Moto,Long> {

    List<Moto> findByUsuarioId(Long iduser);
}
