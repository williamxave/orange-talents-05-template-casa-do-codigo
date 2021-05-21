package br.com.zupacademy.casadocodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Lob;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.model.Categoria;
import br.com.zupacademy.casadocodigo.model.Livro;
import br.com.zupacademy.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.ExistId;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.UniqueValue;

public class LivroRecebeDadosDto {

	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	@NotBlank
	private String isbn;

	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	@NotBlank
	private String titulo;

	@Min(20)
	private BigDecimal preco;

	@Min(100)
	private Integer numeroDePaginas;

	@NotBlank
	@Length(max = 500)
	private String resumo;

	@Lob // Quando o tipo de dados é muito grande
	private String sumario;

	@Future
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private LocalDate data;

	@NotNull
	@ExistId(domainClass = Categoria.class, fieldName = "id")
	private Long autorId;

	@NotNull
	@ExistId(domainClass = Autor.class, fieldName = "id")
	private Long categoriaId;

	public LivroRecebeDadosDto(@NotBlank String isbn, @NotBlank String titulo, @Min(20) BigDecimal preco,
			@Min(100) Integer numeroDePaginas, @NotBlank @Length(max = 500) String resumo, String sumario,
			@Future LocalDate data, Long autorId, Long categoriaId) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.resumo = resumo;
		this.sumario = sumario;
		this.data = data;
		this.autorId = autorId;
		this.categoriaId = categoriaId;
	}

	public Livro toLivro(LivroRecebeDadosDto livroRecebeDadosDto, AutorRepository autorRepository,
			CategoriaRepository categoriaRepository) {
		Autor autor = autorRepository.findById(livroRecebeDadosDto.getAutorId()).get();
		Categoria categoria = categoriaRepository.findById(livroRecebeDadosDto.getCategoriaId()).get();

		Livro livro = new Livro(isbn, titulo, preco, numeroDePaginas, resumo, sumario, data, autor, categoria);

		autor.addLivroNaLista(livro);
		categoria.addLivrosCategoria(livro);

		return livro;
	}

	public Long getAutorId() {
		return autorId;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

}
