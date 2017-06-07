package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 7097942702951244070L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID", unique=true, nullable=true)
	private int id;
	
	@Column(name= "NOME", unique=true, nullable=true)
	private String nome;
	
	@Column(name= "CPF", unique=true, nullable=true)
	private String cpf;
	
	@Column(name= "ENDERECO", unique=true, nullable=true)
	private String endereco;

	@Column(name= "TELEFONE", unique=true, nullable=true)
	private long telefone;
	
//	@ManyToOne(fetch = FetchType.LAZY) 
//	@JoinColumn(name = "DEPARTAMENTO_ID")
//	private Departamento departamento;

	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cpf, String endereco, long telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		//this.departamento = departamento;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", telefone="
				+ telefone + "]";
	}
	
}
