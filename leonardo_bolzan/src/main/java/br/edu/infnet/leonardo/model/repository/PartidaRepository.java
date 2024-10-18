package br.edu.infnet.leonardo.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.leonardo.model.domain.Partida;

@Repository
public interface PartidaRepository extends CrudRepository<Partida, Integer> {

}
