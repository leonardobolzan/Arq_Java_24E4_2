package br.edu.infnet.leonardo.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Partida;
import br.edu.infnet.leonardo.model.repository.PartidaRepository;

@Service
public class PartidaService {

	@Autowired
	private PartidaRepository partidaRepository;

	public Collection<Partida> GetAll(){
		return (Collection<Partida>)partidaRepository.findAll();
	}
	
	public Optional<Partida> GetById(Integer id){
		return partidaRepository.findById(id);
	}
	
	public void Add(Partida partida) {
		partidaRepository.save(partida);
	}
	
	public void Delete(Integer id) {
		partidaRepository.deleteById(id);
	}
}
