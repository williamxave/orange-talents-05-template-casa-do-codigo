package br.com.zupacademy.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.dto.AutorRecebeDadosDto;
import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.repositories.AutorRepository;	

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	public ResponseEntity<?> cadastrarUmAutor(@Valid @RequestBody  AutorRecebeDadosDto autorRecebeDadosDto){
		Autor obj = autorRepository.save(autorRecebeDadosDto.toAutor());
		return ResponseEntity.ok().build();
	}

}