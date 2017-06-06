package br.com.fiap.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.EntityManagerFactorySingleton;

public class Main {

	public static void main(String[] args){
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		Command command = new Command(em);
		
		try{
		
			command.popularFunc();
			command.popularDepartamento();
			command.popularEmpresa();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			em.close();
		}
	}
	
}
