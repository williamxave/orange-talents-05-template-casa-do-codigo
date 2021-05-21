package br.com.zupacademy.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.dto.EstadoRecebeDadosDto;
import br.com.zupacademy.casadocodigo.model.Estado;
import br.com.zupacademy.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.repositories.PaisRepository;

@RestController
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@PostMapping
	public ResponseEntity<?> cadastraEstado(@RequestBody @Valid EstadoRecebeDadosDto estadoRecebeDadosDto) {
		Estado estado = estadoRecebeDadosDto.deEstadoRecebeDadosDtoparaEstado(estadoRecebeDadosDto, paisRepository);
		estadoRepository.save(estado);
		return ResponseEntity.ok().build();
	}
}
