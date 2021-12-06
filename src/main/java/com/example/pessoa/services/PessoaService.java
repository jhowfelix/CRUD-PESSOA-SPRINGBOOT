package com.example.pessoa.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pessoa.dto.PessoaDTO;
import com.example.pessoa.dto.PessoaNoIdDTO;
import com.example.pessoa.entities.Pessoa;
import com.example.pessoa.repositories.PessoaRepository;
import com.example.pessoa.services.exception.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public PessoaNoIdDTO insert(PessoaNoIdDTO pessoa) {
		Pessoa ps = pessoa.toEntity();
		repository.save(ps);
		return pessoa;
	}

	public PessoaNoIdDTO findById(Long id) {
		Optional<Pessoa> ps = repository.findById(id);
		ps.orElseThrow(() -> new ObjectNotFoundException("Not found"));
		PessoaNoIdDTO psdto = new PessoaNoIdDTO(ps.get());
		return psdto;
	}

	public PessoaDTO update(Long id, PessoaDTO request) {
		Optional<Pessoa> ps = repository.findById(id);
		PessoaDTO pessoaDoBanco = new PessoaDTO(ps.get());
		if(request.getNome()==null) {
			request.setNome(pessoaDoBanco.getNome());
		}
		if(request.getIdade() == 0) {
			request.setIdade(pessoaDoBanco.getIdade());
		}
		if(request.getCpf() == 0) {
			request.setCpf(pessoaDoBanco.getIdade());
		}
		if(request.getEndereco() == null) {
			request.setEndereco(pessoaDoBanco.getEndereco());
		}
		pessoaDoBanco.setNome(request.getNome());
		pessoaDoBanco.setIdade(request.getIdade());
		pessoaDoBanco.setCpf(request.getCpf());
		pessoaDoBanco.setEndereco(request.getEndereco());
		repository.save(pessoaDoBanco.toEntity());
		return request;
	}


	public List<PessoaDTO> findAll() {
		List<Pessoa> result = repository.findAll();
		if (result == null) {
			throw new ObjectNotFoundException("Not Found");
		}
		return result.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
	}

	public void deleteById(Long id) {
		findById(id);
		repository.deleteById(id);
	}
}
