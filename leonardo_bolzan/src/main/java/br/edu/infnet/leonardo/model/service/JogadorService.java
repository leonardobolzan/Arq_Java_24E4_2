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

	public Jogador Add(Jogador jogador) {
		return jogadorRepository.save(jogador);
	}

	public void Delete(Integer id) {
		jogadorRepository.deleteById(id);
	}

	public Long CountAll() {
		return jogadorRepository.count();
	}
}
