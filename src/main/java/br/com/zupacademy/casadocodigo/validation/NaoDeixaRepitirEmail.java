package br.com.zupacademy.casadocodigo.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.casadocodigo.dto.AutorRecebeDadosDto;
import br.com.zupacademy.casadocodigo.model.Autor;
import br.com.zupacademy.casadocodigo.repositories.AutorRepository;

@Component
public class NaoDeixaRepitirEmail implements Validator {

	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorRecebeDadosDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) {
			return;
		}
		AutorRecebeDadosDto request = (AutorRecebeDadosDto) target;
		Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
		if (autor.isPresent()) {
			errors.rejectValue("email",null, "Já existe este email cadastrado");
		}
	}

}
