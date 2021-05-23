package br.com.zupacademy.casadocodigo.dto;

import java.util.Optional;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zupacademy.casadocodigo.model.Cliente;
import br.com.zupacademy.casadocodigo.model.Estado;
import br.com.zupacademy.casadocodigo.model.Pais;
import br.com.zupacademy.casadocodigo.repositories.EstadoRepository;
import br.com.zupacademy.casadocodigo.repositories.PaisRepository;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.CpfOuCnpj;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.ExistId;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.UniqueValue;
import br.com.zupacademy.casadocodigo.validation.genericvalidation.VerificaSePaisTemEstadoOuNao;

@VerificaSePaisTemEstadoOuNao
public class ClienteRecebeDadosDto {

	@NotBlank
	@Email
	@Column(unique = true)
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String sobrenome;

	@NotBlank
	@CpfOuCnpj
	@Column(unique = true)
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	private String documento;

	@NotBlank
	private String endereco;

	@NotBlank
	private String cidade;

	@NotBlank
	private String complemento;

	@NotBlank
	private String cep;

	@NotBlank
	private String telefone;

	@JsonProperty(required = false)
	private String nomeEstado;

	@NotNull
	@ExistId(domainClass = Pais.class, fieldName = "id")
	private Long idPais;

	public ClienteRecebeDadosDto(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String cidade,
			@NotBlank String complemento, @NotBlank String cep, @NotBlank String telefone, @NotNull Long idPais) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.cidade = cidade;
		this.complemento = complemento;
		this.cep = cep;
		this.telefone = telefone;
		this.idPais = idPais;
	}

	public Cliente deClienteRecebeDadosDtotoCliente(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(this.idPais).get();
		Optional<String> podeTerUmEstado = Optional.ofNullable(nomeEstado);
		Estado estado = null;
		if (podeTerUmEstado.isPresent()) {
			estado = estadoRepository.findByNomeAndPaisId(nomeEstado, pais.getId()).get();
		}
		return new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, cep, telefone, estado,pais);
	}

	public Long getIdPais() {
		return idPais;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

}
