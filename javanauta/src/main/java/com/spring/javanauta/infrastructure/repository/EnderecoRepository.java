package com.spring.javanauta.infrastructure.repository;

import com.spring.javanauta.infrastructure.entitys.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
