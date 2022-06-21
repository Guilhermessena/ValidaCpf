package com.api.validacpf.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.validacpf.dto.UsuarioDto;
import com.api.validacpf.service.UsuarioService;

/*
 * Endpoints de onde serão acessado os recursos 
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/valida-cpf")
public class UsuarioController {

	/*
	 * ponto de injeção quando necessário acionar o service
	 */
	final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/*
	 * métodos implementados que serão usados pela aplicacao
	 */

	@GetMapping
	public ResponseEntity<Object> validaCpf(@RequestBody @Valid UsuarioDto usuarioDto) {
		if (usuarioService.existsByCpf(usuarioDto.getCpf())) {
			return ResponseEntity.status(HttpStatus.OK).body("Usuario já cadastrado!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Usuario não cadastrado!");
		}
	}

}
