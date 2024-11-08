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

	public Long CountAll() {
		return timeRepository.count();
	}

	public Time Add(Time time) {
		return timeRepository.save(time);
	}

	public Time Update(Time time) {
		if (timeRepository.existsById(time.getId())) {
			return timeRepository.save(time);
		}

		return null;
	}

	public boolean Delete(Integer id) {
		if (timeRepository.existsById(id)) {
			timeRepository.deleteById(id);
			return true;
		}

		return false;
	}
}
