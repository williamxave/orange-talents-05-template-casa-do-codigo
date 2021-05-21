package br.com.zupacademy.casadocodigo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.casadocodigo.model.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {
}
