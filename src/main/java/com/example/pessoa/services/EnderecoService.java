package com.example.pessoa.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pessoa.dto.EnderecoDTO;
import com.example.pessoa.entities.Endereco;
import com.example.pessoa.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public Endereco insert(EnderecoDTO enderecodto) {
		Endereco endereco = enderecodto.toEntity();
		return repository.save(endereco);
	}
	
	public List<EnderecoDTO> findAll() {
		List<Endereco> result = repository.findAll();
		// Convertendo o tipo da lista para DTO
		return result.stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
	}
	public Optional<Endereco> findById(Long id) {
		Optional<Endereco> endereco =  repository.findById(id);
		return endereco;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
