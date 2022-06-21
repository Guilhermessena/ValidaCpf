package com.api.validacpf.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/* Atributos que serão enviados
 * pelo usuário para serem alocados
 * e tramitados entre as camadas
 */

public class UsuarioDto {

	@NotBlank
	@Size(max = 11)
	private String cpf;
	@NotBlank
	private String senha;

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

}
