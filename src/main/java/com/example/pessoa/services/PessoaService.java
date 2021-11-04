package com.example.pessoa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pessoa.dto.PessoaDTO;
import com.example.pessoa.entities.Pessoa;
import com.example.pessoa.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public Pessoa insert(PessoaDTO pessoadto) {
		Pessoa ps = pessoadto.toEntity();
		return repository.save(ps);
	}

	public Optional<Pessoa> findById(Long id) {
		Optional<Pessoa> ps = repository.findById(id);
		return ps;
		

	}

	public Pessoa update(Long id, Pessoa pessoa) throws Exception {
		Pessoa ps;
		Optional<Pessoa> pessoaOptional = findById(id);
		if(pessoaOptional.isPresent()) {
		ps = pessoaOptional.get();
		ps.setNome(pessoa.getNome());
		ps.setIdade(pessoa.getIdade());
		ps.setCpf(pessoa.getCpf());
		ps.setEndereco(pessoa.getEndereco());
		repository.save(ps);
		return ps;
		}
		else {
			throw new Exception("Pessoa não encontrada!");
		}
		
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
