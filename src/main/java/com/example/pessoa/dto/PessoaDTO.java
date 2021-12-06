package com.example.pessoa.dto;

import com.example.pessoa.entities.Endereco;
import com.example.pessoa.entities.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

	private Long id;

	private String nome;

	private int cpf;

	private int idade;

	private Endereco endereco;

	public PessoaDTO(Pessoa entity) {
		id = entity.getId();
		nome = entity.getNome();
		cpf = entity.getCpf();
		idade = entity.getIdade();
		endereco = entity.getEndereco();
	}

	public Pessoa toEntity() {
		return new Pessoa(this.id, this.nome, this.idade, this.cpf, this.endereco);
	}
}