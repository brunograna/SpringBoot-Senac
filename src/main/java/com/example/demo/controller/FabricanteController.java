package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Fabricante;
import com.example.demo.service.FabricanteService;
import com.example.demo.service.FabricanteService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {
	
	@Autowired
	private FabricanteService service;
	
	@GetMapping("/listar")
	public ModelAndView listarFabricantes() {
		ModelAndView mv = new ModelAndView("fabricante/listaFabricante");
		mv.addObject("fabricantes", service.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarFabricante() {
		ModelAndView mv = new ModelAndView("fabricante/cadastraFabricante");
		mv.addObject("fabricante", new Fabricante());
		return mv;		
	}
	
	@PostMapping("/adicionaFabricante")
	public ModelAndView salvarFabricante(Fabricante fabricante) {
		service.save(fabricante);
		return new ModelAndView("redirect:/fabricante/listar");
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarFabricante(@PathVariable("id") Integer id) {
			service.delete(id);
			return new ModelAndView("redirect:/fabricante/listar");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarFabricante(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("fabricante/alteraFabricante");
		mv.addObject("fabricante", service.search(id));
		return mv;		
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Fabricante fabricante) throws ObjectNotFoundException {
		System.out.println(fabricante);
		service.edit(fabricante);
		return new ModelAndView("redirect:/fabricante/listar");
	}
	
}
