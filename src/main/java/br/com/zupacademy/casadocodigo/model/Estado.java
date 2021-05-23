package br.com.zupacademy.casadocodigo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	@OneToMany(mappedBy = "estado")
	private List<Cliente> cliente = new ArrayList<>();

	public Estado(@NotBlank String nome, @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	@Deprecated
	public Estado() {

	}
	public Long getIdEstado() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	

}
