package br.com.zupacademy.casadocodigo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.casadocodigo.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
}
