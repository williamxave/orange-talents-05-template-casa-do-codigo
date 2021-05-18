package br.com.zupacademy.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.dto.CategoriaRecebeDadosDto;
import br.com.zupacademy.casadocodigo.model.Categoria;
import br.com.zupacademy.casadocodigo.repositories.CategoriaRepository;
import br.com.zupacademy.casadocodigo.validation.NaoDeixaRepitirNome;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private NaoDeixaRepitirNome naoDeixaRepitirNome;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(naoDeixaRepitirNome);
	}
	
	
	@PostMapping
	public ResponseEntity<?> cadastrarUmCategoria(@Valid @RequestBody  CategoriaRecebeDadosDto categoriaRecebeDadosDto){
		Categoria obj = categoriaRecebeDadosDto.toCategoria();
		categoriaRepository.save(obj);
		return ResponseEntity.ok().build();
	}
}
