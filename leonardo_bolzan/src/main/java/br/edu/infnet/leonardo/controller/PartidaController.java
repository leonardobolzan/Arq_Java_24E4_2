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

import br.edu.infnet.leonardo.model.domain.Partida;
import br.edu.infnet.leonardo.model.service.PartidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Partidas", description = "Métodos disponíveis para a gestão das partidas.")
@RestController
@RequestMapping("/partidas")
public class PartidaController {

	@Autowired
	private PartidaService partidaService;

	@Operation(summary = "Retorna todas as partidas cadastradas.")
	@GetMapping
	public ResponseEntity<Collection<Partida>> GetAll() {
		return ResponseEntity.ok(partidaService.GetAll());
	}

	@Operation(summary = "Retorna uma partida através do identificador único.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Partida> GetById(@PathVariable Integer id) {
		Partida partida = partidaService.GetById(id);
		return partida != null ? ResponseEntity.ok(partida) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Operation(summary = "Retorna a quantidade de partidas cadastradas.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return partidaService.CountAll();
	}

	@Operation(summary = "Adiciona uma nova partida.")
	@PostMapping
	public ResponseEntity<String> Add(@RequestBody Partida partida) {
		partidaService.Add(partida);
		return ResponseEntity.status(HttpStatus.CREATED).body("Partida cadastrada com sucesso.");
	}

	@Operation(summary = "Remove uma partida através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> Remove(@PathVariable Integer id) {
		if (partidaService.Delete(id)) {
			return ResponseEntity.ok("Partida excluída com sucesso.");
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
