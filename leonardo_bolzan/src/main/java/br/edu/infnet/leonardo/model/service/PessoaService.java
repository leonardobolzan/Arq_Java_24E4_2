package br.edu.infnet.leonardo.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Pessoa;
import br.edu.infnet.leonardo.model.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;

	public Collection<Pessoa> GetAll() {
		return (Collection<Pessoa>) pessoaRepository.findAll();
	}

	public Pessoa GetById(Integer id) {
		return pessoaRepository.findById(id).orElse(null);
	}

	public Long CountAll() {
		return pessoaRepository.count();
	}

	public Pessoa Add(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa Update(Pessoa pessoa) {
		if (pessoaRepository.existsById(pessoa.getId())) {
			return pessoaRepository.save(pessoa);
		}

		return null;
	}

	public boolean Delete(Integer id) {
		if (pessoaRepository.existsById(id)) {
			pessoaRepository.deleteById(id);
			return true;
		}

		return false;
	}
}
