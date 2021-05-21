package br.com.zupacademy.casadocodigo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.casadocodigo.model.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {
	
	Estado findByNome(String nome);

}
