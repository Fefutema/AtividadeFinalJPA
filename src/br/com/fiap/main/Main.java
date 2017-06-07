package br.com.fiap.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.entity.Departamento;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Funcionario;

public class Main {

	public static void main(String[] args){
		EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		
		Command command = new Command(em);
		
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite: \n 1 - Para incluir \n "
				+ "2 - Para listar todas Empresas \n "
				+ "3 - Para listar todos Departamentos \n"
				+ "4 - Para listar todos Funcionarios"));
		
		try{
			switch(opcao) {
			case 1:
				command.popularFunc();
				command.popularDepartamento();
				command.popularEmpresa();
				break;
			case 2:
				
				List<Empresa> listaEmpresas= command.listarEmpresas();
				
				for (Empresa empresa : listaEmpresas) {
					System.out.println(empresa.toString());
				}
				
				break;
			case 3:
				
				List<Departamento> listaDepto = command.listarDepartamentos();
				
				for (Departamento departamento : listaDepto) {
					System.out.println(departamento.toString());
				}
				
				break;
			case 4:
				
				List<Funcionario> listaFunc = command.listarFuncionarios();
				
				for (Funcionario funcionario : listaFunc) {
					System.out.println(funcionario.toString());
				}
				
				break;
			default:
				System.out.println("Essa opção não válida");
				break;
			
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			em.close();
		}
	}
	
}
