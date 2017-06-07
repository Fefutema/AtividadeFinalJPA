package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Departamento;

public interface DepartamentoDAO extends DAO<Departamento, Integer>{

	public List<Departamento> listarTodos();
	
}
