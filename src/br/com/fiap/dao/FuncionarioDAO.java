package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Funcionario;

public interface FuncionarioDAO extends DAO<Funcionario, Integer>{

	public List<Funcionario> listarTodos();
	
}
