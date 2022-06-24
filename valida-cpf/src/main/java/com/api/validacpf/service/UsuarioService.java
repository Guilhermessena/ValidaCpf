package com.api.validacpf.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.validacpf.model.UsuarioModel;
import com.api.validacpf.repository.UsuarioRepository;

	/*
	 * camada intermediária entre
	 * o controller e o repository
	 */

@Service
public class UsuarioService {

	/*
	 * ponto de injeção para quando necessário acionar o repository
	 */
	UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	/*
	 * Exemplo de método chamado pelo controller retornando métodos prontos do jpa
	 */

	public boolean existsByCpf(String cpf) {
		return usuarioRepository.existsByCpf(cpf);
	}

}
