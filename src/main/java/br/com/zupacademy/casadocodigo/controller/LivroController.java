package br.com.zupacademy.casadocodigo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.dto.LivroRecebeDadosDto;
import br.com.zupacademy.casadocodigo.dto.dtoresposta.LivroRespostaDto;
import br.com.zupacademy.casadocodigo.dto.dtoresposta.LivroRespostaPaginadaDto;
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

	@GetMapping
	public ResponseEntity<List<LivroRespostaDto>> buscarListaDeLivros() {
		List<Livro> livros = (List<Livro>) livroRepository.findAll();
		List<LivroRespostaDto> livrosResposta = livros.stream().map(obj -> new LivroRespostaDto(obj))
				.collect(Collectors.toList());
		if (livros.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(livrosResposta);
	}

	@GetMapping("/page/{id}")
	public ResponseEntity<Page<LivroRespostaPaginadaDto>> paginacao(@PathVariable Long id, Pageable paginacao) {
		Optional<Livro> livroVerificado = livroRepository.findById(id);
		if (livroVerificado.isEmpty()) {
			return ResponseEntity.notFound().build();
			
		} else {
			Page<Livro> pageLivro = livroRepository.findById(id, paginacao);
			Page<LivroRespostaPaginadaDto> livrosComId = LivroRespostaPaginadaDto
					.deLivroParaLivroRespostaPaginadaDto(pageLivro);
			return ResponseEntity.ok().body(livrosComId);
		}

	}
}
