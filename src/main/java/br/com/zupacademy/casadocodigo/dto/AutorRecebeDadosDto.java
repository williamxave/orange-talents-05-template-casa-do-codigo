package br.com.zupacademy.casadocodigo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.UniqueValue;

public class AutorRecebeDadosDto {

	@NotBlank
	@NotNull
	@NotEmpty
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email")
	private String email;

	@NotBlank
	@NotNull
	@NotEmpty
	private String nome;

	@NotBlank
	@NotNull
	@NotEmpty
	@Length(max = 400)
	private String descricao;

	@CreationTimestamp
	private LocalDateTime dataDeRegistro;

	public AutorRecebeDadosDto(@NotBlank @NotNull @NotEmpty @Email String email,
			@NotBlank @NotNull @NotEmpty String nome, @NotBlank @NotNull @NotEmpty @Length(max = 400) String descricao,
			LocalDateTime dataDeRegistro) {
		super();
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
		this.dataDeRegistro = dataDeRegistro;
	}

	public Autor toAutor() {
		return new Autor(this.email, this.nome, this.descricao, this.dataDeRegistro);
	}

	public String getEmail() {
		return email;
	}

}