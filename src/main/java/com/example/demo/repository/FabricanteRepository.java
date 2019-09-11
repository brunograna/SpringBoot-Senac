package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Fabricante;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer>{

}
