package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Acessorio;
import com.example.demo.repository.AcessorioRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AcessorioService {

	@Autowired
	AcessorioRepository repository;
	
	public Acessorio search(Integer id) throws ObjectNotFoundException {
		Optional<Acessorio> acessorio = repository.findById(id);
		
		return acessorio.orElseThrow(()-> new ObjectNotFoundException("Não encontrado, id: "+id+", Tipo!"+ Acessorio.class.getName()));
	}
		
	public List<Acessorio> searchAll(){
		return repository.findAll();
	}
	
	public Acessorio save(Acessorio acessorio) {
		return repository.save(acessorio);
	}
	
	public List<Acessorio> saveAll(List<Acessorio> acessorios){
		return repository.saveAll(acessorios);
	}
	
	public Acessorio edit(Acessorio acessorio) throws ObjectNotFoundException{
		Acessorio acessorioAntiga = search(acessorio.getId());
		acessorioAntiga.setNome(acessorio.getNome());
		
		return save(acessorioAntiga);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
