package com.api.validacpf.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.validacpf.model.UsuarioModel;

/*
 * A interface repository que extende
 * o jparepository possui métodos
 * prontos para transações com o banco de dados
 */

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {

	boolean existsByCpf(String cpf);

	Optional<UsuarioModel> findOne(String cpf);

}
