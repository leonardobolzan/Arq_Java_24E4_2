package br.edu.infnet.leonardo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Time;
import br.edu.infnet.leonardo.model.repository.TimeRepository;

@Service
public class TimeService {
	@Autowired
	private TimeRepository timeRepository;

	public Collection<Time> GetAll() {
		return (Collection<Time>) timeRepository.findAll();
	}

	public Time GetById(Integer id) {
		return timeRepository.findById(id).orElse(null);
	}

	public void Add(Time time) {
		timeRepository.save(time);
	}

	public void Delete(Integer id) {
		timeRepository.deleteById(id);
	}

	public Long CountAll() {
		return timeRepository.count();
	}
}
