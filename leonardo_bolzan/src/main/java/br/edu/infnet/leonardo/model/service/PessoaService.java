package br.edu.infnet.leonardo.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.leonardo.model.domain.Pessoa;
import br.edu.infnet.leonardo.model.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;

	public Collection<Pessoa> GetAll(){
		return (Collection<Pessoa>)pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> GetById(Integer id){
		return pessoaRepository.findById(id);
	}
	
	public void Add(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	public void Delete(Integer id) {
		pessoaRepository.deleteById(id);
	}
}
