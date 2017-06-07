package br.com.fiap.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import br.com.fiap.dao.DepartamentoDAO;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.dao.FuncionarioDAO;
import br.com.fiap.entity.Departamento;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.impl.DepartamentoDAOImpl;
import br.com.fiap.impl.EmpresaDAOImpl;
import br.com.fiap.impl.FuncionarioDAOImpl;

public class Command {
	private EmpresaDAO empresaDAO;
	private DepartamentoDAO departamentoDAO;
	private FuncionarioDAO funcionarioDAO;
	private List<Funcionario> listFuncionarios;
	private List<Departamento> listDeptos;
	private EntityManager em;

	public Command(EntityManager em) {
		this.em = em;
	}
	
	public void popularFunc() {
		listFuncionarios = new ArrayList<>();
		String qtFuncionarios = JOptionPane.showInputDialog("Quantos funcionarios deseja incluir?");
		for (int i = 0; i < Integer.valueOf(qtFuncionarios); i++) {
			Funcionario funcionario = new Funcionario();
			String nome = JOptionPane.showInputDialog("Digite o nome " + i + ":  ");
			String cpf = JOptionPane.showInputDialog("Digite o cpf " + i + ":  ");
			String endereco = JOptionPane.showInputDialog("Digite o endereco" + i + ":  ");
			String telefone = JOptionPane.showInputDialog("Digite o telefone " + i + ":  ");

			funcionario.setCpf(cpf);
			funcionario.setEndereco(endereco);
			funcionario.setNome(nome);
			funcionario.setTelefone(Long.parseLong(telefone));
			listFuncionarios.add(funcionario);
		}
	
		this.incluirFunc();
	}

	private void incluirFunc(){
		this.funcionarioDAO = new FuncionarioDAOImpl(this.em);
		
		for (Funcionario funcionario : listFuncionarios) {
			this.funcionarioDAO.insert(funcionario);
			System.out.println("Funcionario " + funcionario.getNome() + " incluido com sucesso");
		}
	}
	
	public void popularDepartamento(){
		Departamento depto = new Departamento();
		listDeptos = new ArrayList<>();
		
		String nomeDepto = JOptionPane.showInputDialog("Digite o nome do depto: ");
		String local = JOptionPane.showInputDialog("Digite o local do depto: Ex.:4 andar ");
		
		depto.setNome(nomeDepto);
		depto.setLocalizacao(local);
		depto.setFuncionarios(listFuncionarios);
		
		this.departamentoDAO = new DepartamentoDAOImpl(this.em);
		
		departamentoDAO.insert(depto);
		
		listDeptos.add(depto);
		
	}
	
	public void popularEmpresa(){
		Empresa empresa = new Empresa();
		
		String nomeEmpresa = JOptionPane.showInputDialog("Digite o nome da empresa: ");
		String cnpj = JOptionPane.showInputDialog("Digite o CNPJ da empresa: ");
		
		empresa.setNome(nomeEmpresa);
		empresa.setCnpj(cnpj);
		empresa.setDepartamentos(listDeptos);

		empresaDAO = new EmpresaDAOImpl(this.em);
		
		empresaDAO.insert(empresa);
		
	}
	
	public List<Empresa> listarEmpresas(){
		empresaDAO = new EmpresaDAOImpl(this.em);
		
		List<Empresa> lista = empresaDAO.listarTodas();
		
		return lista;
		
	}
	
	
	public List<Departamento> listarDepartamentos(){
		departamentoDAO = new DepartamentoDAOImpl(this.em);
		
		List<Departamento> lista = departamentoDAO.listarTodos();
		
		return lista;
		
	}
	
	public List<Funcionario> listarFuncionarios(){
		funcionarioDAO = new FuncionarioDAOImpl(this.em);
		
		List<Funcionario> lista = funcionarioDAO.listarTodos();
		
		return lista;
		
	}
	
	public Empresa buscaEmpresa(int id){
		empresaDAO = new EmpresaDAOImpl(this.em);
		
		return empresaDAO.findById(id);
		
	}
	
	public Departamento buscaDepto(int id){
		departamentoDAO = new DepartamentoDAOImpl(this.em);
		
		return departamentoDAO.findById(id);
		
	}
	
	public Funcionario buscaFuncionario(int id){
		funcionarioDAO = new FuncionarioDAOImpl(this.em);
		
		return funcionarioDAO.findById(id);
		
	}
	
}
