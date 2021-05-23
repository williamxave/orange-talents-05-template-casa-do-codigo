package br.com.zupacademy.casadocodigo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zupacademy.casadocodigo.model.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {


	Optional<Estado> findByPaisId(Long idPais);

	Optional<Estado> findByNomeAndPaisId(String nomeEstado, Long idPais);

}
