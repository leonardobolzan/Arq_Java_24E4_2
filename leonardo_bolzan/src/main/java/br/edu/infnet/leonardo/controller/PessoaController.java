package br.edu.infnet.leonardo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Collection<Pessoa>> GetAll() {
		return ResponseEntity.ok(pessoaService.GetAll());
	}

	@Operation(summary = "Retorna uma pessoa através do identificador único.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> GetById(@PathVariable Integer id) {
		Pessoa pessoa = pessoaService.GetById(id);
		return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Operation(summary = "Retorna a quantidade de pessoas cadastradas.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return pessoaService.CountAll();
	}

	@Operation(summary = "Adiciona uma nova pessoa.")
	@PostMapping
	public ResponseEntity<String> Add(@RequestBody Pessoa pessoa) {
		pessoaService.Add(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa cadastrada com sucesso.");
	}

	@Operation(summary = "Remove uma pessoa através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> Remove(@PathVariable Integer id) {
		if (pessoaService.Delete(id)) {
			return ResponseEntity.ok("Pessoa excluída com sucesso.");
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
