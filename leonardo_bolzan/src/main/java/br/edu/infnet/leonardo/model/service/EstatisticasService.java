package br.edu.infnet.leonardo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Estatisticas;
import br.edu.infnet.leonardo.model.repository.EstatisticasRepository;

@Service
public class EstatisticasService {
	@Autowired
	private EstatisticasRepository estatisticasRepository;

	public Collection<Estatisticas> GetAll() {
		return (Collection<Estatisticas>) estatisticasRepository.findAll();
	}

	public Estatisticas GetById(Integer id) {
		return estatisticasRepository.findById(id).orElse(null);
	}

	public Estatisticas Add(Estatisticas estatisticas) {
		return estatisticasRepository.save(estatisticas);
	}

	public void Delete(Integer id) {
		estatisticasRepository.deleteById(id);
	}

	public Long CountAll() {
		return estatisticasRepository.count();
	}
}
