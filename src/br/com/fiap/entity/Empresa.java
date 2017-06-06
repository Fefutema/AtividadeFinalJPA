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
public class Empresa implements Serializable{

	private static final long serialVersionUID = 7097942702951244070L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "ID", unique=true, nullable=true)
	private int id;
	
	@Column(name= "NOME", unique=true, nullable=true)
	private String nome;
	
	@Column(name= "cnpj", unique=true, nullable=true)
	private String cnpj;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Departamento> departamentos = new ArrayList<>();
	
	public Empresa() {
		super();
	}

	public Empresa(String nome, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
	}



	public Empresa(String nome, String cnpj, List<Departamento> departamentos) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.departamentos = departamentos;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

}
