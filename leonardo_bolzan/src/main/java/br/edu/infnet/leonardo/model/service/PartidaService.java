package br.edu.infnet.leonardo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Partida;
import br.edu.infnet.leonardo.model.repository.PartidaRepository;

@Service
public class PartidaService {

	@Autowired
	private PartidaRepository partidaRepository;
	
	public void AddPartida(Partida partida) {
		partidaRepository.save(partida);
	}
	
	public Collection<Partida> GetAll(){
		return (Collection<Partida>)partidaRepository.findAll();
	}
}
