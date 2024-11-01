package br.edu.infnet.leonardo.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Narrador;
import br.edu.infnet.leonardo.model.repository.NarradorRepository;

@Service
public class NarradorService {
	@Autowired
	private NarradorRepository narradorRepository;

	public Collection<Narrador> GetAll(){
		return (Collection<Narrador>)narradorRepository.findAll();
	}
	
	public Optional<Narrador> GetById(Integer id){
		return narradorRepository.findById(id);
	}
	
	public void Add(Narrador narrador) {
		narradorRepository.save(narrador);
	}
	
	public void Delete(Integer id) {
		narradorRepository.deleteById(id);
	}
}
