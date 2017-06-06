package br.com.fiap.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DAO;

public abstract class DAOImpl<T,K> implements DAO<T, K> {
	
	protected EntityManager em;
	protected Class<T> entityClass;
	
	public DAOImpl(EntityManager em) {
		this.em = em;
		this.entityClass = (Class) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]; 
	}
	
	@Override
	public void insert(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	@Override
	public void remove(T entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}
	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}
	@Override
	public T findById(K id) {
		return em.find(entityClass, id);
	}

}
