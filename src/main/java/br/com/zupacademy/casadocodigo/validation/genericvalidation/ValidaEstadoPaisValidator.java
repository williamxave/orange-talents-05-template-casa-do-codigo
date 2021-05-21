package br.com.zupacademy.casadocodigo.validation.genericvalidation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.aspectj.bridge.Message;
import org.springframework.util.Assert;

import br.com.zupacademy.casadocodigo.dto.EstadoRecebeDadosDto;

public class ValidaEstadoPaisValidator implements ConstraintValidator<ValidaEstadoPais, EstadoRecebeDadosDto> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void initialize(ValidaEstadoPais params) {
	}

	@Override
	public boolean isValid(EstadoRecebeDadosDto estadoRecebeDadosDto, ConstraintValidatorContext context) {
		String jpql = "select c from Estado c where c.nome = :nome and c.pais.id = :idPais";
		Query query = manager.createQuery(jpql);

		query.setParameter("nome", estadoRecebeDadosDto.getNome());
		query.setParameter("idPais", estadoRecebeDadosDto.getIdPais());
		List<?> list = query.getResultList();
		
		if(!list.isEmpty()) {
			throw new IllegalStateException();
		}
		
		
		return list.isEmpty();
	}
}
