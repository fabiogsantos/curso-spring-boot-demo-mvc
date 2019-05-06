package com.mballem.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mballem.curso.boot.dao.DepartamentoDao;
import com.mballem.curso.boot.domain.Departamento;

@Service
@Transactional(readOnly=false)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao dao;
	
	@Override
	public void salvar(Departamento departamento) {
		dao.save(departamento);
	}

	@Override
	public void editar(Departamento departamento) {
		dao.update(departamento);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly=true)
	public Departamento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override @Transactional(readOnly=true)
	public List<Departamento> buscarTodos() {
		return dao.findAll();
	}

	@Override @Transactional(readOnly=true)
	public boolean departamentoTemCargos(Long id) {
		Departamento departamento = buscarPorId(id);
		if (departamento != null) {		
		  return (! departamento.getCargos().isEmpty());
		}  
	    return false;
	}

}
