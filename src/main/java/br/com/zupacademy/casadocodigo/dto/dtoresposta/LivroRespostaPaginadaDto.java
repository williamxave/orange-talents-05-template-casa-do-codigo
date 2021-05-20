package br.com.zupacademy.casadocodigo.dto.dtoresposta;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Page;

import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.model.Categoria;
import br.com.zupacademy.casadocodigo.model.Livro;

public class LivroRespostaPaginadaDto {

	private Long id;

	private String isbn;

	private String titulo;

	private BigDecimal preco;

	private Integer numeroDePaginas;

	private String resumo;

	private String sumario;

	private LocalDate data;

	private Autor autor;

	private Categoria categoria;

	public LivroRespostaPaginadaDto(Livro livro) {
		super();
		this.id = livro.getId();
		this.isbn = livro.getIsbn();
		this.titulo = livro.getTitulo();
		this.preco = livro.getPreco();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.data = livro.getData();
		this.autor = livro.getAutor();
		this.categoria = livro.getCategoria();
	}

	public static Page<LivroRespostaPaginadaDto> deLivroParaLivroRespostaPaginadaDto(Page<Livro> livros) {
		return livros.map(LivroRespostaPaginadaDto::new);
	}

	public Long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
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

	public LocalDate getData() {
		return data;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
