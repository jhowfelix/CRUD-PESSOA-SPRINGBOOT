package com.example.pessoa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pessoa.dto.EnderecoDTO;
import com.example.pessoa.entities.Endereco;
import com.example.pessoa.services.EnderecoService;

@RestController
@RequestMapping(value = "/api/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	@PostMapping
	public Endereco insert(@RequestBody EnderecoDTO Endereco) {
		return service.insert(Endereco);
	}

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> findAll() {
		List<EnderecoDTO> result = service.findAll();
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/{id}")
	public Optional<Endereco> findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
