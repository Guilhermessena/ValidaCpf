package com.api.validacpf.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.validacpf.AplicationConfigTest;
import com.api.validacpf.model.UsuarioModel;

@DisplayName("UsuarioServiceTest")
public class UsuarioServiceTest extends AplicationConfigTest {

	@Autowired
	private UsuarioService usuarioService;

	@Test
	@DisplayName("Testa se o cpf existe.")
	void existsByCpf() {
		UsuarioModel usuario = new UsuarioModel("60154516880", "hdsbnfhsdbh");
		Assertions.assertTrue(usuarioService.existsByCpf(usuario.getCpf()));
		
		
//		String cpf = "60154516880";
//		boolean valida = usuarioService.existsByCpf(cpf);
//
//		Assertions.assertEquals(valida, "60154516880");
	}

//	@Before
//	public void setup() {
//
//		UsuarioModel usuario = new UsuarioModel("60154516880", "123321");
//
//		Mockito.when(usuarioRepository.existsByCpf(usuario.getCpf())).thenReturn(true);
//	}

}
