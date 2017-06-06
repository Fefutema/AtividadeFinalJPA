package br.com.fiap.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import com.mysql.fabric.xmlrpc.base.Array;

import br.com.fiap.dao.DAO;
import br.com.fiap.dao.DepartamentoDAO;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.impl.FuncionarioDAOImpl;

public class Command {
	private String optioin;
	private EmpresaDAO empresaDAO;
	private DepartamentoDAO departamentoDAO;
	private FuncionarioDAO funcionarioDAO;
	private List<Funcionario> listFuncionarios;
	private EntityManagerFactory entityManagerFactory = EntityManagerFactorySingleton.getInstance();
	private EntityManager em = entityManagerFactory.createEntityManager();

	public void step1() {
		listFuncionarios = new ArrayList<>();
		JOptionPane jOptionPane = new JOptionPane();
		String qtFuncionarios = jOptionPane.showInputDialog("Quantos funcionarios deseja incluir?");
		for (int i = 0; i < Integer.valueOf(qtFuncionarios); i++) {
			Funcionario funcionario = new Funcionario();
			String nome = jOptionPane.showInputDialog("Inclua os funcionarios ");
			String cpf = jOptionPane.showInputDialog("Inclua os funcionarios ");
			String endereco = jOptionPane.showInputDialog("Inclua os funcionarios ");
			String telefone = jOptionPane.showInputDialog("Inclua os funcionarios ");

			funcionario.setCpf(cpf);
			funcionario.setEndereco(endereco);
			funcionario.setNome(nome);
			funcionario.setTelefone(Long.parseLong(telefone));
			listFuncionarios.add(funcionario);
		}
	
		this.step2();
	}

	private void step2(){
		this.funcionarioDAO = new FuncionarioDAOImpl(this.em);
		
		for (Funcionario funcionario : listFuncionarios) {
			this.funcionarioDAO.insert(funcionario);
		}
	}
	
	
	
	
}
