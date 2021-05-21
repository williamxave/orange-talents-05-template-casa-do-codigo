package br.com.zupacademy.casadocodigo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.casadocodigo.model.Estado;
import br.com.zupacademy.casadocodigo.model.Pais;
import br.com.zupacademy.casadocodigo.repositories.PaisRepository;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.ExistId;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.ValidaEstadoPais;

@ValidaEstadoPais
public class EstadoRecebeDadosDto {
	
	@NotBlank
	private String nome;

	@NotNull
	@ExistId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public EstadoRecebeDadosDto(@NotBlank String nome, @NotNull Long idPais) {
		this.nome = nome;
		this.idPais = idPais;
	}
	

	public Long getIdPais() {
		return idPais;
	}

	public String getNome() {
		return nome;
	}

	public Estado deEstadoRecebeDadosDtoparaEstado(EstadoRecebeDadosDto estadoRecebeDadosDto,
			PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(estadoRecebeDadosDto.getIdPais()).get();
		return new Estado(this.nome, pais);
	}
}
