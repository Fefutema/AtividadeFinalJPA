package br.com.fiap.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.DepartamentoDAO;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entity.Departamento;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.impl.DepartamentoDAOImpl;
import br.com.fiap.impl.EmpresaDAOImpl;
import br.com.fiap.impl.FuncionarioDAOImpl;

public class Main {

	public static void main(String[] args){
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		List<Funcionario> funcionarios = new ArrayList<>();
		Funcionario f1 = new Funcionario("Michel", "123456798", "Rua xxxx", 85142655);
		Funcionario f2 = new Funcionario("Michel2", "99876547", "Rua eeee", 52865854);		
		
		funcionarios.add(f1);
		funcionarios.add(f2);
		
		FuncionarioDAO funcDao = new FuncionarioDAOImpl(em);
		funcDao.insert(f1);
		funcDao.insert(f2);
		
		Departamento depto = new Departamento("Financeiro", "4 Andar", funcionarios);

		List<Departamento> deptos = new ArrayList<>();
		deptos.add(depto);
		
		DepartamentoDAO deptoDao = new DepartamentoDAOImpl(em);
		deptoDao.insert(depto);
		
		Empresa empresa = new Empresa("Ford", "1202051512", deptos);
		
		EmpresaDAO empresaDao = new EmpresaDAOImpl(em);
		empresaDao.insert(empresa);
		
		
		
	}
	
}
