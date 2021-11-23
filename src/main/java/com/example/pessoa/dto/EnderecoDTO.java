package com.example.pessoa.dto;

import com.example.pessoa.entities.Endereco;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

	private Long id;
	private String rua;
	private int cep;
	private int numero;

	public EnderecoDTO(Endereco enderecoEntity) {
		id = enderecoEntity.getId();
		rua = enderecoEntity.getRua();
		cep = enderecoEntity.getCep();
		numero = enderecoEntity.getNumero();

	}

	public Endereco toEntity() {
		return new Endereco(null, this.rua, this.cep, this.numero);
	}
}
