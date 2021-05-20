package br.com.zupacademy.casadocodigo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.casadocodigo.model.Livro;

@Repository
public interface LivroRepository extends PagingAndSortingRepository<Livro, Long> {
	
	Page<Livro> findById(Long id, Pageable paginacao);
	
	Page<Livro> findAll(Pageable paginacao);
}
