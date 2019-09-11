package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Fabricante;
import com.example.demo.repository.FabricanteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FabricanteService {
	
	@Autowired
	FabricanteRepository fabricanteRepository;
	
	public Fabricante search(Integer id) throws ObjectNotFoundException {
		Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
		
		return fabricante.orElseThrow(()-> new ObjectNotFoundException("Não encontrado, id: "+id+", Tipo!"+ Fabricante.class.getName()));
	}
		
	public List<Fabricante> searchAll(){
		return fabricanteRepository.findAll();
	}
	
	public Fabricante save(Fabricante doc) {
		return fabricanteRepository.save(doc);
	}
	
	public List<Fabricante> saveAll(List<Fabricante> docs){
		return fabricanteRepository.saveAll(docs);
	}
	
	public Fabricante edit(Fabricante fabricante) throws ObjectNotFoundException{		
		
		Fabricante fabricanteAntigo = search(fabricante.getId());
		fabricanteAntigo.setNome(fabricante.getNome());
		
		return save(fabricanteAntigo);
	}
	
	public void delete(Integer id) {
		fabricanteRepository.deleteById(id);
	}

}
