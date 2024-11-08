package br.edu.infnet.leonardo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Jogador;
import br.edu.infnet.leonardo.model.repository.JogadorRepository;

@Service
public class JogadorService {
	@Autowired
	private JogadorRepository jogadorRepository;

	public Collection<Jogador> GetAll() {
		return (Collection<Jogador>) jogadorRepository.findAll();
	}

	public Jogador GetById(Integer id) {
		return jogadorRepository.findById(id).orElse(null);
	}

	public Long CountAll() {
		return jogadorRepository.count();
	}

	public Jogador Add(Jogador jogador) {
		return jogadorRepository.save(jogador);
	}

	public Jogador Update(Jogador jogador) {
		if (jogadorRepository.existsById(jogador.getId())) {
			return jogadorRepository.save(jogador);
		}

		return null;
	}

	public boolean Delete(Integer id) {
		if (jogadorRepository.existsById(id)) {
			jogadorRepository.deleteById(id);
			return true;
		}

		return false;
	}
}
