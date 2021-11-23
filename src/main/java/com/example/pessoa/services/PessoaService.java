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
		ps.orElseThrow(() -> new ObjectNotFoundException("Pessoa não cadastrada"));
		PessoaNoIdDTO psdto = new PessoaNoIdDTO(ps.get());
		return psdto;
	}

	public PessoaNoIdDTO update(Long id, PessoaNoIdDTO pesso) {
		try {
			Pessoa ps;
			PessoaNoIdDTO pessoadto = findById(id);
			if (pessoadto != null) {
				ps = pessoadto.toEntity();
				ps.setNome(pessoadto.getNome());
				ps.setIdade(pessoadto.getIdade());
				ps.setCpf(pessoadto.getCpf());
				ps.setEndereco(pessoadto.getEndereco());
				repository.save(ps);
				return pesso;
			} else {
				throw new ObjectNotFoundException("Pessoa não encontrada!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public List<PessoaDTO> findAll() {
		List<Pessoa> result = repository.findAll();
		return result.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
