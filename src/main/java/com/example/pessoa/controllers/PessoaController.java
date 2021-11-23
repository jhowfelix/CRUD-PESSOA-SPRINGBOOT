package com.example.pessoa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping(value = "/api/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@PostMapping
	public ResponseEntity<PessoaNoIdDTO> insert(@RequestBody PessoaNoIdDTO pessoa) {
		return ResponseEntity.ok(service.insert(pessoa));
	}
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll( ){
		List<PessoaDTO> result = service.findAll();
		return ResponseEntity.ok(result);
	}
	@GetMapping(value ="/{id}")
	public ResponseEntity<PessoaNoIdDTO> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaNoIdDTO> update(@PathVariable("id") Long id, @RequestBody PessoaNoIdDTO pessoa) throws Exception{
		return ResponseEntity.ok(service.update(id, pessoa));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		service.deleteById(id);
		return ResponseEntity.ok(null);
	}


}
