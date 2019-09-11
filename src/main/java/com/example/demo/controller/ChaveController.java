package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Chave;
import com.example.demo.service.ChaveService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/chave")
public class ChaveController {
	
	@Autowired
	private ChaveService service;
	
	@GetMapping("/listar")
	public ModelAndView listarChaves() {
		ModelAndView mv = new ModelAndView("chave/listaChave");
		mv.addObject("chaves", service.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarChave() {
		ModelAndView mv = new ModelAndView("chave/cadastraChave");
		mv.addObject("chave", new Chave());
		return mv;		
	}
	
	@PostMapping("/adicionaChave")
	public ModelAndView salvarChave(Chave chave) {
		service.save(chave);
		return new ModelAndView("redirect:/chave/listar");
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarChave(@PathVariable("id") Integer id) {
			service.delete(id);
			return new ModelAndView("redirect:/chave/listar");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarChave(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("chave/alteraChave");
		mv.addObject("chave", service.search(id));
		return mv;		
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Chave chave) throws ObjectNotFoundException {
		service.edit(chave);
		return new ModelAndView("redirect:/chave/listar");
	}
}
