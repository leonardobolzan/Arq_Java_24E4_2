package br.edu.infnet.leonardo.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Canal;
import br.edu.infnet.leonardo.model.repository.CanalRepository;

@Service
public class CanalService {
	@Autowired
	private CanalRepository canalRepository;

	public Collection<Canal> GetAll(){
		return (Collection<Canal>)canalRepository.findAll();
	}
	
	public Optional<Canal> GetById(Integer id){
		return canalRepository.findById(id);
	}
	
	public void Add(Canal canal) {
		canalRepository.save(canal);
	}
	
	public void Delete(Integer id) {
		canalRepository.deleteById(id);
	}
}
