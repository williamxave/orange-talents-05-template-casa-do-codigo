package br.com.zupacademy.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.dto.LivroRecebeDadosDto;
import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.model.Categoria;
import br.com.zupacademy.casadocodigo.model.Livro;
import br.com.zupacademy.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.casadocodigo.repositories.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;


	@PostMapping
	public ResponseEntity<?> cadastraUmLivro(@RequestBody @Valid LivroRecebeDadosDto livroRecebeDadosDto) {
		
		Livro livro = livroRecebeDadosDto.toLivro(livroRecebeDadosDto, autorRepository, categoriaRepository);
	
		livroRepository.save(livro);
		return ResponseEntity.ok().build();
	}

}
