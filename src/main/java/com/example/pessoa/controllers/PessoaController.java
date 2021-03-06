package com.example.pessoa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pessoa.dto.PessoaDTO;
import com.example.pessoa.dto.PessoaNoIdDTO;
import com.example.pessoa.services.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST PESSOA")
@CrossOrigin(origins = "*")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@PostMapping
	@ApiOperation(value = "Adiciona uma pessoa no banco em h2")
	public ResponseEntity<PessoaNoIdDTO> insert(@RequestBody PessoaNoIdDTO pessoa) {
		service.insert(pessoa);
		return ResponseEntity.ok(pessoa);
	}

	@GetMapping
	@ApiOperation(value = "Retorna todas as pessoas do banco")
	public ResponseEntity<List<PessoaDTO>> findAll() {
		List<PessoaDTO> result = service.findAll();
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna a pessoa pelo id")
	public ResponseEntity<PessoaNoIdDTO> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping(value = "/{id}")
	@ApiOperation(value = "Atualiza uma pessoa.")
	public ResponseEntity<PessoaDTO> update(@PathVariable("id") Long id, @RequestBody PessoaDTO pessoa) {
		service.update(id, pessoa);
		return ResponseEntity.ok(pessoa);
	}

	@DeleteMapping(path = "/{id}")
	@ApiOperation(value = "Deleta uma pessoa pelo id")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.deleteById(id);
		return ResponseEntity.ok(null);
	}

}
