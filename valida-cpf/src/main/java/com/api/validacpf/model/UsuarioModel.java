package com.api.validacpf.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/* Classe que irá ser persistida 
 * na base de dados
 */

@Entity
@Table(name = "TB_VALIDA_CPF")
public class UsuarioModel implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * Atributos que possuem nullable, unique ou length precisam seguir essa regra
	 * na entrada de dados
	 */

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private UUID id;
	@Column(nullable = false, unique = true, length = 11)
	private String cpf;
	@Column(nullable = false, unique = true, length = 15)
	private String senha;

//	public UUID getId() {
//		return id;
//	}
//
//	public void setId(UUID id) {
//		this.id = id;
//	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UsuarioModel(String cpf, String senha) {
		super();
		// this.id = id;
		this.cpf = cpf;
		this.senha = senha;
	}

}
