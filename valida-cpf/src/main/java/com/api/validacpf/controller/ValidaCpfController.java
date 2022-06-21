package com.api.validacpf.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.validacpf.dto.UsuarioDto;
import com.api.validacpf.model.UsuarioModel;
import com.api.validacpf.service.UsuarioService;

/*
 * Endpoints de onde serão acessado os recursos 
 */

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/valida-cpf")
public class ValidaCpfController {

	/*
	 * ponto de injeção quando necessário acionar o service
	 */
	final UsuarioService validaCpfService;

	public ValidaCpfController(UsuarioService validaCpfService) {
		this.validaCpfService = validaCpfService;
	}

	/*
	 * métodos implementados que serão usados pela aplicacao
	 */

	@PostMapping
	public ResponseEntity<Object> saveCpf(@RequestBody @Valid UsuarioDto validaCpfDto) {
		if (validaCpfService.existsByCpf(validaCpfDto.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado!");
		}
		UsuarioModel validaCpfModel = new UsuarioModel();
		BeanUtils.copyProperties(validaCpfDto, validaCpfModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(validaCpfService.save(validaCpfModel));
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<Object> getOneCpf(@PathVariable(value = "cpf") String cpf) {
		Optional<UsuarioModel> validaCpfModelOptional = validaCpfService.findByCpf(cpf);

		return ResponseEntity.status(HttpStatus.OK).body(validaCpfModelOptional.get());
	}

}
