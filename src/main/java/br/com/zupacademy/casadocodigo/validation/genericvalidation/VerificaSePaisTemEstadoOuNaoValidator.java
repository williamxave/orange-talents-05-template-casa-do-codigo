package br.com.zupacademy.casadocodigo.validation.genericvalidation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import br.com.zupacademy.casadocodigo.dto.ClienteRecebeDadosDto;
import br.com.zupacademy.casadocodigo.model.Estado;
import br.com.zupacademy.casadocodigo.repositories.EstadoRepository;

@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class VerificaSePaisTemEstadoOuNaoValidator
		implements ConstraintValidator<VerificaSePaisTemEstadoOuNao, ClienteRecebeDadosDto> {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public void initialize(VerificaSePaisTemEstadoOuNao params) {
	}

	@Override
	public boolean isValid(ClienteRecebeDadosDto value, ConstraintValidatorContext context) {
		Optional<Estado> paisComEstadoTalvez = estadoRepository.findByPaisId(value.getIdPais());
		Optional<String> talvezEstadoNome = Optional.ofNullable(value.getNomeEstado());
		if (paisComEstadoTalvez.isPresent()) {
			if (talvezEstadoNome.isPresent()) {
				Optional<Estado> talvezTenhaEstadoNoPais = estadoRepository.findByNomeAndPaisId(value.getNomeEstado(),
						value.getIdPais());
				return talvezTenhaEstadoNoPais.isPresent();
			}
			return false;
		}
		return talvezEstadoNome.isEmpty();
	}
}
