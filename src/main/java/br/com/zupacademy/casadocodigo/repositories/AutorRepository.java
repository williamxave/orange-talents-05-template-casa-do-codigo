package br.com.zupacademy.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.casadocodigo.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long>{

	Optional<Autor> findByEmail(String email);

}