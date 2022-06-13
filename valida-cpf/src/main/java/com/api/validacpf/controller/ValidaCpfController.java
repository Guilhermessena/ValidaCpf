package com.api.validacpf.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.validacpf.dto.ValidaCpfDto;
import com.api.validacpf.model.ValidaCpfModel;
import com.api.validacpf.service.ValidaCpfService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/valida-cpf")
public class ValidaCpfController {

	final ValidaCpfService validaCpfService;

	public ValidaCpfController(ValidaCpfService validaCpfService) {
		this.validaCpfService = validaCpfService;
	}

	@PostMapping
	public ResponseEntity<Object> saveValidaCpf(@RequestBody @Valid ValidaCpfDto validaCpfDto) {
		if (validaCpfService.existsByCpf(validaCpfDto.getCpf())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario ja foi cadastrado");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Usuario não foi cadastrado");
		}
	}

}
