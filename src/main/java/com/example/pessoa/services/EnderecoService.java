package com.example.pessoa.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.pessoa.dto.EnderecoDTO;
import com.example.pessoa.entities.Endereco;
import com.example.pessoa.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public ResponseEntity<EnderecoDTO> insert(EnderecoDTO enderecodto) {
		Endereco endereco = enderecodto.toEntity();
		repository.save(endereco);
		return ResponseEntity.ok(enderecodto);
	}

	public List<EnderecoDTO> findAll() {
		List<Endereco> result = repository.findAll();
		return result.stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
	}

	public EnderecoDTO findById(Long id) {
		Optional<Endereco> endereco = repository.findById(id);
		EnderecoDTO enderecodto = new EnderecoDTO(endereco.get());
		return enderecodto;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
