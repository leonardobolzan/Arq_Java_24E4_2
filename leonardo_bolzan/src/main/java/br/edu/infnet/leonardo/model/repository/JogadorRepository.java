package br.edu.infnet.leonardo.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.leonardo.model.domain.Jogador;

@Repository
public interface JogadorRepository extends CrudRepository<Jogador, Integer> {

}
