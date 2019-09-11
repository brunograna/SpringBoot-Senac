package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Acessorio;
import com.example.demo.service.AcessorioService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/acessorio")
public class AcessorioController {
	
	@Autowired
	private AcessorioService service;
	
	@GetMapping("/listar")
	public ModelAndView listarAcessorios() {
		ModelAndView mv = new ModelAndView("acessorio/listaAcessorio");
		mv.addObject("acessorios", service.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAcessorio() {
		ModelAndView mv = new ModelAndView("acessorio/cadastraAcessorio");
		mv.addObject("acessorio", new Acessorio());
		return mv;		
	}
	
	@PostMapping("/adicionaAcessorio")
	public ModelAndView salvarAcessorio(Acessorio acessorio) {
		service.save(acessorio);
		return new ModelAndView("redirect:/acessorio/listar");
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarAcessorio(@PathVariable("id") Integer id) {
			service.delete(id);
			return new ModelAndView("redirect:/acessorio/listar");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAcessorio(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("acessorio/alteraAcessorio");
		mv.addObject("acessorio", service.search(id));
		return mv;		
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Acessorio acessorio) throws ObjectNotFoundException {
		service.edit(acessorio);
		return new ModelAndView("redirect:/acessorio/listar");
	}
	
}