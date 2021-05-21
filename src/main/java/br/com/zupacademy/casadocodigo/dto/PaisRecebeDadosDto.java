package br.com.zupacademy.casadocodigo.dto;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.casadocodigo.model.Estado;
import br.com.zupacademy.casadocodigo.model.Pais;
import br.com.zupacademy.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.ExistId;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.UniqueValue;

public class PaisRecebeDadosDto {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	@ExistId(domainClass = Pais.class, fieldName = "id")
	private Long idEstado;

	public PaisRecebeDadosDto(@NotBlank String nome, Long idEstado) {
		this.nome = nome;
		this.idEstado = idEstado;
	}

	public PaisRecebeDadosDto(@NotBlank String nome) {
		this.nome = nome;
	
	}

	public String getNome() {
		return nome;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public Pais dePaisRecebeDadosDtoParaPais(PaisRecebeDadosDto paisRecebeDadosDto, EstadoRepository estadoRepository) {
		
		if (paisRecebeDadosDto.getIdEstado() != null) {
			Estado estado = estadoRepository.findById(paisRecebeDadosDto.getIdEstado()).get();
			return new Pais(this.nome, estado);
		}
		return new Pais(this.nome);

	}

}
