package com.mballem.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.mballem.curso.boot.doamin.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
