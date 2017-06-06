package br.com.fiap.dao;

public interface DAO<T,K> {
	
	void insert(T entity);
	
	void remove(T entity);
	
	void update(T entity);
	
	T findById(K id);

}
