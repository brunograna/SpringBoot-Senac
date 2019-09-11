package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Documento;
import com.example.demo.repository.DocumentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DocumentoService {
	
	@Autowired
	DocumentoRepository documentoRepository;
	
	public Documento search(Integer id) throws ObjectNotFoundException {
		Optional<Documento> doc = documentoRepository.findById(id);
		
		return doc.orElseThrow(()-> new ObjectNotFoundException("Não encontrado, id: "+id+", Tipo!"+ Documento.class.getName()));
	}
		
	public List<Documento> searchAll(){
		return documentoRepository.findAll();
	}
	
	public Documento save(Documento doc) {
		return documentoRepository.save(doc);
	}
	
	public List<Documento> saveAll(List<Documento> docs){
		return documentoRepository.saveAll(docs);
	}
	
	public Documento edit(Documento doc) throws ObjectNotFoundException{		
		
		Documento docAntigo = search(doc.getId());
		docAntigo.setCodigo(doc.getCodigo());
		docAntigo.setNome(doc.getNome());
		
		return save(docAntigo);
	}
	
	public void delete(Integer id) {
		documentoRepository.deleteById(id);
	}
}
