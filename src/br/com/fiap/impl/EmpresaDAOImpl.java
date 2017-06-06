package br.com.fiap.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.entity.Empresa;

public class EmpresaDAOImpl extends DAOImpl<Empresa, Integer> implements EmpresaDAO{

	public EmpresaDAOImpl(EntityManager em) {
		super(em);
	}

}
