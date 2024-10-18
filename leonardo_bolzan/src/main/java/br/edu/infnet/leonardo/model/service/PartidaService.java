package br.edu.infnet.leonardo.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Partida;
import br.edu.infnet.leonardo.model.repository.PartidaRepository;

@Service
public class PartidaService {

	@Autowired
	private PartidaRepository partidaRepository;
	
	private Map<String, Partida> mapPartidas = new HashMap<String, Partida>();
	
	public void AddPartida(Partida partida) {
		mapPartidas.put(partida.getIdentificador(), partida);
		partidaRepository.save(partida);
	}
	
	public Collection<Partida> GetAll(){
		return mapPartidas.values();
	}
}
