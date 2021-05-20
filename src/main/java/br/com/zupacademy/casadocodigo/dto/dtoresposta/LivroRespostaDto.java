package br.com.zupacademy.casadocodigo.dto.dtoresposta;

import br.com.zupacademy.casadocodigo.model.Livro;

public class LivroRespostaDto {

	private Long id;
	private String titulo;

	@Deprecated
	public LivroRespostaDto() {

	}

	public LivroRespostaDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}


}
