package br.edu.infnet.leonardo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.leonardo.model.domain.Pessoa;
import br.edu.infnet.leonardo.model.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pessoas", description = "Métodos disponíveis para a gestão das pessoas.")
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Operation(summary = "Retorna todas as pessoas cadastradas.")
	@GetMapping
	public Collection<Pessoa> GetAll() {
		return pessoaService.GetAll();
	}

	@Operation(summary = "Retorna uma pessoa através do identificador único.")
	@GetMapping(value = "/{id}")
	public Optional<Pessoa> GetById(@PathVariable Integer id) {
		return pessoaService.GetById(id);
	}

	@Operation(summary = "Retorna a quantidade de pessoas cadastradas.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return pessoaService.CountAll();
	}

	@Operation(summary = "Adiciona uma nova pessoa.")
	@PostMapping
	public String Add(@RequestBody Pessoa pessoa) {
		pessoaService.Add(pessoa);
		return "Pessoa cadastrada com sucesso.";
	}

	@Operation(summary = "Remove uma pessoa através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public String Remove(@PathVariable Integer id) {
		pessoaService.Delete(id);
		return "Pessoa excluída com sucesso.";
	}
}
