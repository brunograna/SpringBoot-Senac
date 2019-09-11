package com.example.demo.controller;

import com.example.demo.service.ChaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Carro;
import com.example.demo.service.CarroService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	private CarroService service;

	@Autowired
	private ChaveService chaveService;
	
	@GetMapping("/listar")
	public ModelAndView listarCarros() {
		ModelAndView mv = new ModelAndView("carro/listaCarro");
		mv.addObject("carros", service.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarCarro() {
		ModelAndView mv = new ModelAndView("carro/cadastraCarro");
		mv.addObject("chaves", chaveService.searchAll());
		mv.addObject("carro", new Carro());
		return mv;		
	}
	
	@PostMapping("/adicionaCarro")
	public ModelAndView salvarCarro(Carro carro) {
		service.save(carro);
		return new ModelAndView("redirect:/carro/listar");
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarCarro(@PathVariable("id") Integer id) {
			service.delete(id);
			return new ModelAndView("redirect:/carro/listar");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarCarro(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("carro/alteraCarro");
		mv.addObject("chaves", chaveService.searchAll());
		mv.addObject("carro", service.search(id));
		return mv;		
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Carro carro) throws ObjectNotFoundException {
		service.edit(carro);
		return new ModelAndView("redirect:/carro/listar");
	}
}
