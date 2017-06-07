package br.com.fiap.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.entity.Empresa;

public class EmpresaDAOImpl extends DAOImpl<Empresa, Integer> implements EmpresaDAO{

	public EmpresaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Empresa> listarTodas() {
		TypedQuery<Empresa> query = em.createQuery("from Empresa", Empresa.class);
		
		return query.getResultList();
	}

}
