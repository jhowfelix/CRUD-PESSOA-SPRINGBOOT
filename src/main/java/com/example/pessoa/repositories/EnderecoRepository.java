package com.example.pessoa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pessoa.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
