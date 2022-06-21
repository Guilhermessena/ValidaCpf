package com.api.validacpf.service;

import java.util.Optional;

import javax.transaction.Transactional;

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
	UsuarioRepository validaCpfRepository;

	public UsuarioService(UsuarioRepository validaCpfRepository) {
		this.validaCpfRepository = validaCpfRepository;
	}

	/*
	 * Exemplo de método chamado pelo controller retornando métodos prontos do jpa
	 */

	@Transactional
	public UsuarioModel save(UsuarioModel validaCpfModel) {
		return validaCpfRepository.save(validaCpfModel);
	}

	public boolean existsByCpf(String cpf) {
		return validaCpfRepository.existsByCpf(cpf);
	}

	public Object findOne() {
		return null;
	}

	public Optional<UsuarioModel> findByCpf(String cpf) {
		return null;
	}

}
