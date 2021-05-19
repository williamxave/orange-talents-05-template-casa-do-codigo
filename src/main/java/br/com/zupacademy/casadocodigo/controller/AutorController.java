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

import br.com.zupacademy.casadocodigo.dto.AutorRecebeDadosDto;
import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.repositories.AutorRepository;
import br.com.zupacademy.casadocodigo.validation.NaoDeixaRepitirEmail;	

@RestController
@RequestMapping("/autor")
public class AutorController {

	@Autowired
	private NaoDeixaRepitirEmail  naoDeixaRepitirEmail;
	
	@Autowired
	private AutorRepository autorRepository;
	
	//@InitBinder
//	public void init(WebDataBinder binder) {
	//	binder.addValidators(naoDeixaRepitirEmail);
		
//	}

	@PostMapping
	public ResponseEntity<?> cadastrarUmAutor(@Valid @RequestBody AutorRecebeDadosDto autorRecebeDadosDto){
		Autor obj = autorRecebeDadosDto.toAutor();
		autorRepository.save(obj);
		return ResponseEntity.ok().build();
	}

}