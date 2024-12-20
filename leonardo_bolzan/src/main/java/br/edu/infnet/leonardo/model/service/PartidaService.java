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

	public Long CountAll() {
		return partidaRepository.count();
	}

	public Partida Add(Partida partida) {
		return partidaRepository.save(partida);
	}

	public Partida Update(Partida partida) {
		if (partidaRepository.existsById(partida.getId())) {
			return partidaRepository.save(partida);
		}

		return null;
	}

	public boolean Delete(Integer id) {
		if (partidaRepository.existsById(id)) {
			partidaRepository.deleteById(id);
			return true;
		}

		return false;
	}
}
