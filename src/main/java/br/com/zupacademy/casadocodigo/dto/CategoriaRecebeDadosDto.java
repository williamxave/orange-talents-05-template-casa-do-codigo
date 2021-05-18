package br.com.zupacademy.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.casadocodigo.model.Categoria;

public class CategoriaRecebeDadosDto {

	@NotBlank
	private String nome;

	public CategoriaRecebeDadosDto() {
	}

	public CategoriaRecebeDadosDto(@NotBlank String nome) {
		if(nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException();
		}
		this.nome = nome;
	}

	public Categoria toCategoria() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return nome;
	}

}
