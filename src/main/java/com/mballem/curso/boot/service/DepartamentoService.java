package com.mballem.curso.boot.service;

import java.util.List;

import com.mballem.curso.boot.doamin.Departamento;

public interface DepartamentoService {
	
	void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);

	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();	

}
