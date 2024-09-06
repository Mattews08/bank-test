package com.demo.bank_system.repository;

import com.demo.bank_system.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, String> {
    boolean existsByCpf(String cpf);

    Optional<Pessoa> findByCpf(String cpf);
}
