package br.com.zupacademy.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zupacademy.casadocodigo.model.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);

}