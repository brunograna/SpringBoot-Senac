package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Documento;
import com.example.demo.service.DocumentoService;


import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/documento")
public class DocumentoController {
	
	@Autowired
	private DocumentoService service;
	
	@GetMapping("/listar")
	public ModelAndView listarDocumentos() {
		ModelAndView mv = new ModelAndView("documento/listaDocumento");
		mv.addObject("documentos", service.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarDocumento() {
		ModelAndView mv = new ModelAndView("documento/cadastraDocumento");
		mv.addObject("documento", new Documento());
		return mv;		
	}
	
	@PostMapping("/adicionaDocumento")
	public ModelAndView salvarDocumento(Documento documento) {
		service.save(documento);
		return new ModelAndView("redirect:/documento/listar");
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarDocumento(@PathVariable("id") Integer id) {
			service.delete(id);
			return new ModelAndView("redirect:/documento/listar");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarDocumento(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("documento/alteraDocumento");
		mv.addObject("documento", service.search(id));
		return mv;		
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Documento documento) throws ObjectNotFoundException {
		System.out.println(documento);
		service.edit(documento);
		return new ModelAndView("redirect:/documento/listar");
	}
}
