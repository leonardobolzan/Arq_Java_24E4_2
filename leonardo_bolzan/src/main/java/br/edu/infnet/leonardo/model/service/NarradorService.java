package br.edu.infnet.leonardo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Narrador;
import br.edu.infnet.leonardo.model.repository.NarradorRepository;

@Service
public class NarradorService {
	@Autowired
	private NarradorRepository narradorRepository;

	public Collection<Narrador> GetAll() {
		return (Collection<Narrador>) narradorRepository.findAll();
	}

	public Narrador GetById(Integer id) {
		return narradorRepository.findById(id).orElse(null);
	}

	public Long CountAll() {
		return narradorRepository.count();
	}

	public Narrador Add(Narrador narrador) {
		return narradorRepository.save(narrador);
	}

	public Narrador Update(Narrador narrador) {
		if (narradorRepository.existsById(narrador.getId())) {
			return narradorRepository.save(narrador);
		}

		return null;
	}

	public boolean Delete(Integer id) {
		if (narradorRepository.existsById(id)) {
			narradorRepository.deleteById(id);
			return true;
		}

		return false;
	}
}
