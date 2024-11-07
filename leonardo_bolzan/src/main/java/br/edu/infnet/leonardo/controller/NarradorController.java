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

import br.edu.infnet.leonardo.model.domain.Narrador;
import br.edu.infnet.leonardo.model.service.NarradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Narradores", description = "Métodos disponíveis para a gestão dos narradores das partidas.")
@RestController
@RequestMapping("/narradores")
public class NarradorController {

	@Autowired
	private NarradorService narradorService;

	@Operation(summary = "Retorna todos os narradores cadastrados.")
	@GetMapping
	public ResponseEntity<Collection<Narrador>> GetAll() {
		return ResponseEntity.ok(narradorService.GetAll());
	}

	@Operation(summary = "Retorna um narrador através do identificador único.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Narrador> GetById(@PathVariable Integer id) {
		Narrador narrador = narradorService.GetById(id);
		return narrador != null ? ResponseEntity.ok(narrador) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Operation(summary = "Retorna a quantidade de narradores cadastrados.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return narradorService.CountAll();
	}

	@Operation(summary = "Adiciona um novo narrador.")
	@PostMapping
	public ResponseEntity<String> Add(@RequestBody Narrador narrador) {
		narradorService.Add(narrador);
		return ResponseEntity.status(HttpStatus.CREATED).body("Narrador cadastrado com sucesso.");
	}

	@Operation(summary = "Remove um narrador através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public String Remove(@PathVariable Integer id) {
		narradorService.Delete(id);
		return "Narrador excluído com sucesso.";
	}
}
