package com.api.validacpf.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.validacpf.model.ValidaCpfModel;
import com.api.validacpf.repository.ValidaCpfRepository;

@Service
public class ValidaCpfService {

	ValidaCpfRepository validaCpfRepository;

	public ValidaCpfService(ValidaCpfRepository validaCpfRepository) {
		this.validaCpfRepository = validaCpfRepository;
	}

	@Transactional
	public ValidaCpfModel save(ValidaCpfModel validaCpfModel) {
		return validaCpfRepository.save(validaCpfModel);
	}

	public boolean existsByCpf(String cpf) {
		return validaCpfRepository.existsByCpf(cpf);
	}

}
