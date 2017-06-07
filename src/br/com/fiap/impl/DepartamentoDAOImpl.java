package br.com.fiap.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.DepartamentoDAO;
import br.com.fiap.entity.Departamento;

public class DepartamentoDAOImpl extends DAOImpl<Departamento, Integer> implements DepartamentoDAO{

	public DepartamentoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Departamento> listarTodos() {
		TypedQuery<Departamento> query = em.createQuery("from Departamento", Departamento.class);
		return query.getResultList();
	}

}
