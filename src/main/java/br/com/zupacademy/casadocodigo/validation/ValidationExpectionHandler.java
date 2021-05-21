package br.com.zupacademy.casadocodigo.validation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExpectionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		ValidationError erro = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação",
				System.currentTimeMillis());

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			erro.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public ResponseEntity<StandardError> invalidDataAccessApiUsageException(InvalidDataAccessApiUsageException e,
			HttpServletRequest request) {
		StandardError erro = new StandardError(HttpStatus.BAD_REQUEST.value(),
				"Não é permitido o cadastro de um estado sem seu país", System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	

	@ExceptionHandler(IllegalStateException.class)
	public ResponseEntity<StandardError> IllegalStateException(IllegalStateException e,
			HttpServletRequest request) {
		StandardError erro = new StandardError(HttpStatus.BAD_REQUEST.value(),
				"Não pode existir 2 estados iguais no mesmo país", System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	
	
	
}
