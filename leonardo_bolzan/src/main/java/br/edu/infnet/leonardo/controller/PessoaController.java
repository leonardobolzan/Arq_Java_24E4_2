package br.edu.infnet.leonardo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.leonardo.model.domain.Pessoa;
import br.edu.infnet.leonardo.model.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping(value = "/pessoas")
	public Collection<Pessoa> GetAll() {
		return pessoaService.GetAll();
	}

	@GetMapping(value = "/pessoas/{id}")
	public Optional<Pessoa> GetById(@PathVariable Integer id) {
		return pessoaService.GetById(id);
	}

	@GetMapping(value = "/pessoas/count")
	public Long CountAll() {
		return pessoaService.CountAll();
	}

	@PostMapping(value = "/pessoas/new")
	public String Add(@RequestBody Pessoa pessoa) {
		pessoaService.Add(pessoa);
		return "Pessoa cadastrada com sucesso.";
	}

	@DeleteMapping(value = "/pessoas/{id}")
	public String Remove(@PathVariable Integer id) {
		pessoaService.Delete(id);
		return "Pessoa excluída com sucesso.";
	}
}
