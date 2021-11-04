package com.example.pessoa.controllers;

import java.util.List;
import java.util.Optional;

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
import com.example.pessoa.entities.Pessoa;
import com.example.pessoa.services.PessoaService;

@RestController
@RequestMapping(value = "/api/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@PostMapping
	public Pessoa insert(@RequestBody PessoaDTO pessoa) {
		return service.insert(pessoa);
	}
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> result = service.findAll();
		return ResponseEntity.ok(result);
	}
	@GetMapping(value ="/{id}")
	public Optional<Pessoa> findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}
	
	@PutMapping(value = "/{id}")
	public Pessoa update(@PathVariable("id") Long id, @RequestBody Pessoa pessoa) throws Exception{
		return service.update(id, pessoa);
	}
	
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}


}
