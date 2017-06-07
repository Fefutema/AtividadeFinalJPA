package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Empresa;

public interface EmpresaDAO extends DAO<Empresa, Integer>{

	public List<Empresa> listarTodas();
	
	
}
