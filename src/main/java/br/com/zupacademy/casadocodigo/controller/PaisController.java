package br.com.zupacademy.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.dto.PaisRecebeDadosDto;
import br.com.zupacademy.casadocodigo.model.Pais;
import br.com.zupacademy.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.repositories.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	public ResponseEntity<?> cadastraPais(@RequestBody @Valid PaisRecebeDadosDto paisRecebeDadosDto) {
		Pais paisRecebido = paisRecebeDadosDto.dePaisRecebeDadosDtoParaPais(paisRecebeDadosDto, estadoRepository);
		paisRepository.save(paisRecebido);
		return ResponseEntity.ok().build();

	}

}
