package br.com.zupacademy.casadocodigo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.casadocodigo.dto.ClienteRecebeDadosDto;
import br.com.zupacademy.casadocodigo.dto.dtoresposta.ClienteRespostaDto;
import br.com.zupacademy.casadocodigo.model.Cliente;
import br.com.zupacademy.casadocodigo.repositories.ClienteRepository;
import br.com.zupacademy.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.repositories.PaisRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	public ResponseEntity<ClienteRespostaDto> cadastraCliente(
			@RequestBody @Valid ClienteRecebeDadosDto clienteRecebeDadosDto) {
		Cliente cliente = clienteRecebeDadosDto.deClienteRecebeDadosDtotoCliente(estadoRepository, paisRepository);
		clienteRepository.save(cliente);
		return ResponseEntity.ok().body(new ClienteRespostaDto(cliente));
	}
}
