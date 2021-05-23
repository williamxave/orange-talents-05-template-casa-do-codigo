package br.com.zupacademy.casadocodigo.dto.dtoresposta;

import br.com.zupacademy.casadocodigo.model.Cliente;

public class ClienteRespostaDto {

	private Long id;

	public ClienteRespostaDto(Cliente cliente) {
		this.id = cliente.getId();
	}

	@Deprecated
	public ClienteRespostaDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
