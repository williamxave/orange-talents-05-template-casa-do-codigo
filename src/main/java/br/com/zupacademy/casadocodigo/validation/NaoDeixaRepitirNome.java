package br.com.zupacademy.casadocodigo.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zupacademy.casadocodigo.dto.CategoriaRecebeDadosDto;
import br.com.zupacademy.casadocodigo.model.Categoria;
import br.com.zupacademy.casadocodigo.repositories.CategoriaRepository;

@Component
public class NaoDeixaRepitirNome implements Validator{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRecebeDadosDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()){
			return;
		}
		CategoriaRecebeDadosDto request = (CategoriaRecebeDadosDto) target;
		Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());
		if(categoria.isPresent()) {
			errors.rejectValue("nome", null, "Esse nome já esta cadastrado");
		}
		
	}

}
