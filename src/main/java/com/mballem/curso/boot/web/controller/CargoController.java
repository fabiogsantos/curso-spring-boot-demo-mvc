package com.mballem.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mballem.curso.boot.domain.Cargo;
import com.mballem.curso.boot.domain.Departamento;
import com.mballem.curso.boot.service.CargoService;
import com.mballem.curso.boot.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService service;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	  @GetMapping("/cadastrar")
	  public String cadastrar(Cargo cargo) {
		  return "/cargo/cadastro";
	  }

	  @GetMapping("/listar")
	  public String listar() {
		  return "/cargo/lista";
	  }

	  @PostMapping("/salvar")
	  public String salvar(Cargo cargo, RedirectAttributes attr) {
		  service.salvar(cargo);
		  attr.addFlashAttribute("success","Cargo inserido com sucesso.");
		  return "redirect:/cargos/cadastrar";
	  }
	  
	  @ModelAttribute("departamentos")
	  public List<Departamento> listaDeDepartamentos() {
		  return departamentoService.buscarTodos(); 
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
