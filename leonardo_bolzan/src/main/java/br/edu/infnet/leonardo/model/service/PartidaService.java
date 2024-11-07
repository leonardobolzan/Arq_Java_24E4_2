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

	public Collection<Partida> GetAll() {
		return (Collection<Partida>) partidaRepository.findAll();
	}

	public Partida GetById(Integer id) {
		return partidaRepository.findById(id).orElse(null);
	}

	public void Add(Partida partida) {
		partidaRepository.save(partida);
	}

	public void Delete(Integer id) {
		partidaRepository.deleteById(id);
	}

	public Long CountAll() {
		return partidaRepository.count();
	}
}
