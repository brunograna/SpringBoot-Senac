package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.demo.domain.Chave;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaveRepository extends JpaRepository<Chave, Integer> {

}
