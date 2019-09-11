package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Chave;
import com.example.demo.repository.ChaveRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ChaveService {
	@Autowired
	ChaveRepository chaveRepository;
	
	public Chave search(Integer id) throws ObjectNotFoundException {
		Optional<Chave> chave = chaveRepository.findById(id);
		
		return chave.orElseThrow(()-> new ObjectNotFoundException("Não encontrado, id: "+id+", Tipo!"+ Chave.class.getName()));
	}
		
	public List<Chave> searchAll(){
		return chaveRepository.findAll();
	}
	
	public Chave save(Chave chave) {
		return chaveRepository.save(chave);
	}
	
	public List<Chave> saveAll(List<Chave> chaves){
		return chaveRepository.saveAll(chaves);
	}
	
	public Chave edit(Chave chave) throws ObjectNotFoundException{
		Chave chaveAntiga = search(chave.getId());
		chaveAntiga.setCodigo(chave.getCodigo());
		
		return save(chaveAntiga);
	}
	
	public void delete(Integer id) {
		chaveRepository.deleteById(id);
	}
}
