package com.example.pessoa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pessoa.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
