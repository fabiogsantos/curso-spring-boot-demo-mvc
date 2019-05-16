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
import com.mballem.curso.boot.domain.Funcionario;
import com.mballem.curso.boot.service.CargoService;
import com.mballem.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
	@Autowired
	private CargoService cargoService;
	
	  @GetMapping("/cadastrar")
	  public String cadastrar(Funcionario funcionario) {
		  return "/functionario/cadastro";
	  }

	  @GetMapping("/listar")
	  public String listar(ModelMap model) {
		  model.addAttribute("funcionarios",service.buscarTodos());		  
		  return "/funcionario/lista";
	  }

	  @PostMapping("/salvar")
	  public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		  service.salvar(funcionario);
		  attr.addFlashAttribute("success","Cargo inserido com sucesso.");
		  return "redirect:/funcionarios/cadastrar";
	  }
		 
	  @GetMapping("/editar/{id}")
	  public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		  model.addAttribute("funcionario", service.buscarPorId(id));
		  return "/funcionario/cadastro";
	  }
	  
	  @PostMapping("/editar")
	  public String editar(Funcionario funcionario, RedirectAttributes attr) {
		  service.editar(funcionario);
		  attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		  return "redirect:/funcionarios/cadastrar";
	  }
	  
	  @GetMapping("/excluir/{id}")
	  public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		  if  (service.funcionarioTemCargos(id)) {
			    attr.addFlashAttribute("fail", "Funcionario não removido. Possui cargos(s) vinculados(s).");
		  } else {
			  service.excluir(id);			  
			  attr.addFlashAttribute("success", "Funcionario removido com sucesso.");
		  }
		  return "redirect:/funcionarios/listar";
	  }
	  
	  @ModelAttribute("cargos")
	  public List<Cargo> listaDeCargos() {
		  return cargoService.buscarTodos(); 
	  }	  
}
