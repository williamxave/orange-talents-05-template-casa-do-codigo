package br.com.zupacademy.casadocodigo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@OneToMany(mappedBy = "pais")
	private List<Cliente> cliente = new ArrayList<Cliente>();

	@OneToMany(mappedBy = "pais")
	private static List<Estado> estados = new ArrayList<>();

	public Pais(@NotBlank String nome, Estado estado) {
		this.nome = nome;
	}

	public Pais(@NotBlank String nome) {
		this.nome = nome;
	}

	@Deprecated
	public Pais() {
	}

	public static void addNaLista(Estado estado) {
		estados.add(estado);
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

}
