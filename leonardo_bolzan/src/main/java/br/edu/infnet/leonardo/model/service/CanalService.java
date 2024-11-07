package br.edu.infnet.leonardo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Canal;
import br.edu.infnet.leonardo.model.repository.CanalRepository;

@Service
public class CanalService {
	@Autowired
	private CanalRepository canalRepository;

	public Collection<Canal> GetAll() {
		return (Collection<Canal>) canalRepository.findAll();
	}

	public Canal GetById(Integer id) {
		return canalRepository.findById(id).orElse(null);
	}

	public Canal Add(Canal canal) {
		return canalRepository.save(canal);
	}

	public boolean Delete(Integer id) {
		
		if (canalRepository.existsById(id)) {
			canalRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

	public Long CountAll() {
		return canalRepository.count();
	}
}
