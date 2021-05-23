package br.com.zupacademy.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

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
	private String sobrenome;

	@NotBlank
	@Column(unique = true)
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cidade;

	@NotBlank
	private String cep;

	@NotBlank
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String cep, @NotBlank String telefone, Estado estado,
			@NotNull Pais pais) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.telefone = telefone;
		this.estado = estado;
		this.pais = pais;
	}

	@Deprecated
	public Cliente() {
	}

	public Long getId() {
		return id;
	}

}
