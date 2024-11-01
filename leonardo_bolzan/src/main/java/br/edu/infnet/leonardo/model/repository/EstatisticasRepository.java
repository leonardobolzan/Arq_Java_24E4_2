package br.edu.infnet.leonardo.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.leonardo.model.domain.Estatisticas;

@Repository
public interface EstatisticasRepository extends CrudRepository<Estatisticas, Integer> {

}
