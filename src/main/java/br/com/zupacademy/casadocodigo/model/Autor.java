package br.com.zupacademy.casadocodigo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Email
	@Column(unique = true)
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	@Length(max = 400)
	private String descricao;

	@CreationTimestamp
	private LocalDateTime dataDeRegistro = LocalDateTime.now();

	@OneToMany(mappedBy = "autor")
	private List<Livro> livros = new ArrayList<>();

	public Autor() {

	}

	public Autor(@NotBlank @NotNull @NotEmpty @Email String email, @NotBlank @NotNull @NotEmpty String nome,
			@NotBlank @NotNull @NotEmpty @Length(max = 400) String descricao, LocalDateTime dataDeRegistro) {
		this.email = email;
		this.nome = nome;
		this.descricao = descricao;
		this.dataDeRegistro = dataDeRegistro;
	}

	public Long getId() {
		return id;
	}

	public List<Livro> addLivroNaLista(Livro livro) {
		livros.add(livro);
		return livros;

	}

}