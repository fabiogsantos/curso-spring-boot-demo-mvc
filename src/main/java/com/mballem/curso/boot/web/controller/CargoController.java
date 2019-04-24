package com.mballem.curso.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mballem.curso.boot.domain.Cargo;
import com.mballem.curso.boot.service.CargoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService service;
	
	  @GetMapping("/cadastrar")
	  public String cadastrar(Cargo cargo) {
		  return "/cargo/cadastro";
	  }

	  @GetMapping("/listar")
	  public String listar() {
		  return "/cargo/lista";
	  }

	  @PostMapping("/salvar")
	  public String salvar(Cargo cargo) {
		  service.salvar(cargo);
		  return "redirect:/cargos/cadastrar";
	  }

		 
	  @GetMapping("/editar/{id}")
	  public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		  model.addAttribute("cargo", service.buscarPorId(id));
		  return "/cargo/cadastro";
	  }
	  
	  @PostMapping("/editar")
	  public String editar(Cargo cargo) {
		  service.editar(cargo);
		  return "redirect:/cargos/cadastrar";
	  }	  
}
