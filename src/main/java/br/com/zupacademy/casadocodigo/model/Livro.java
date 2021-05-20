package br.com.zupacademy.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(unique = true)
	private String isbn;

	@NotBlank
	@Column(unique = true)
	private String titulo;

	@Min(20)
	private BigDecimal preco;

	@Min(100)
	private Integer numeroDePaginas;

	@NotBlank
	@Lob
	private String resumo;

	@Lob
	private String sumario;

	@Future
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@Deprecated
	public Livro() {

	}

	public Livro(@NotBlank String isbn, @NotBlank String titulo, @Min(20) BigDecimal preco,
			@Min(100) Integer numeroDePaginas, @NotBlank String resumo, String sumario, @Future LocalDate data,
			Autor autor, Categoria categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.resumo = resumo;
		this.sumario = sumario;
		this.data = data;
		this.autor = autor;
		this.categoria = categoria;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getData() {
		return data;
	}

	public String getIsbn() {
		return isbn;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
