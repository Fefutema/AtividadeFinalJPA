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
				+ "4 - Para listar todos Funcionario \n"
				+ "5 - Para buscar uma empresa pelo ID \n"
				+ "6 - Para buscar um departamento pelo ID \n"
				+ "7 - para buscar um funcionario pelo ID"));
		
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
			case 5:
				int idEmpresa = Integer.parseInt(JOptionPane.showInputDialog("Qual id da empresa ?"));
				
				Empresa emp = command.buscaEmpresa(idEmpresa);
				
				if(emp != null){
					System.out.println(emp.toString());
				}
				else {
					System.out.println("Nenhuma empresa encontrada");
				}
				
				break;
			case 6:
				int idDepto = Integer.parseInt(JOptionPane.showInputDialog("Qual id do departamento ?"));
				
				Departamento depto = command.buscaDepto(idDepto);
				if(depto != null){
					System.out.println(depto.toString());
				}else {
					System.out.println("Nenhum departamento encontrado");
				}
				
				break;
			case 7:
				int idFunc = Integer.parseInt(JOptionPane.showInputDialog("Qual id do Funcionario ?"));
				
				Funcionario func = command.buscaFuncionario(idFunc);

				if(func != null){
					System.out.println(func.toString());
				}else {
					System.out.println("Nenhum funcionario encontrado");
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
