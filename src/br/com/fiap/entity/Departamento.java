package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento implements Serializable{

	private static final long serialVersionUID = 4769734970778530458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID", unique=true, nullable=true)
	private int id;
	
	@Column(name= "NOME", unique=true, nullable=true)
	private String nome;
	
	@Column(name= "LOCALIZACAO", unique=true, nullable=true)
	private String localizacao;

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	
	public Departamento() {
		super();
	}

	public Departamento(String nome, String localizacao) {
		super();
		this.nome = nome;
		this.localizacao = localizacao;
	}



	public Departamento(String nome, String localizacao, List<Funcionario> funcionarios) {
		super();
		this.nome = nome;
		this.localizacao = localizacao;
		this.funcionarios = funcionarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + ", localizacao=" + localizacao + ", funcionarios="
				+ funcionarios + "]";
	}

}
