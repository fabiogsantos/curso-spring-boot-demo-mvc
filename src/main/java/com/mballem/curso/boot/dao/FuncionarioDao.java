package com.mballem.curso.boot.dao;

import java.util.List;

import com.mballem.curso.boot.doamin.Funcionario;

public interface FuncionarioDao {
	
	void save(Funcionario Funcionario);
	
	void update(Funcionario Funcionario);

	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();
}
