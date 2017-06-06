package br.com.fiap.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DepartamentoDAO;
import br.com.fiap.entity.Departamento;

public class DepartamentoDAOImpl extends DAOImpl<Departamento, Integer> implements DepartamentoDAO{

	public DepartamentoDAOImpl(EntityManager em) {
		super(em);
	}

}
