package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer>{

}
