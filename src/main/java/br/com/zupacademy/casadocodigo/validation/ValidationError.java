package br.com.zupacademy.casadocodigo.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	
	private List<FieldMessage> list =  new ArrayList<>();
	
	public ValidationError(Integer status, String mensagem, Long timeStamp) {
		super(status, mensagem, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return list;
	}

	public void addError(String fielNome, String messagem) {
		list.add(new FieldMessage(fielNome, messagem));
	}
	
	
}
