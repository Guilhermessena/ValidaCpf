package com.api.validacpf.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.validacpf.model.ValidaCpfModel;

@Repository
public interface ValidaCpfRepository extends JpaRepository<ValidaCpfModel, UUID> {
	boolean existsByCpf(String cpf);

}
