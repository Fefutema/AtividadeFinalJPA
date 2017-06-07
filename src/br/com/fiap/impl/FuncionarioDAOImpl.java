package br.com.fiap.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entity.Funcionario;

public class FuncionarioDAOImpl extends DAOImpl<Funcionario, Integer> implements FuncionarioDAO{

	public FuncionarioDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Funcionario> listarTodos() {
		TypedQuery<Funcionario> query = em.createQuery("from Funcionario", Funcionario.class);
		
		return query.getResultList();
	}

}
