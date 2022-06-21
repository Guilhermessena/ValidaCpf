package com.api.validacpf;

import java.util.UUID;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.validacpf.service.UsuarioService;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

	@TestConfiguration
	static class UsuarioServiceTestConfiguration {
		@Bean
		public UsuarioService usuarioService() {
			return new UsuarioService(cpf);
		}
	}

	@Autowired
	UsuarioService usuarioService;

	@Test
	public void validaCpfTestService() {
		String cpf = "60154516880";
		boolean mensagem = usuarioService.existsByCpf(cpf);

		Assertions.assertEquals(mensagem, true);
	}
	
	@Before
	public void setup(){
		UUID id  = 
	}
}
