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
	public Collection<Partida> GetAll() {
		return partidaService.GetAll();
	}

	@Operation(summary = "Retorna uma partida através do identificador único.")
	@GetMapping(value = "/{id}")
	public Optional<Partida> GetById(@PathVariable Integer id) {
		return partidaService.GetById(id);
	}

	@Operation(summary = "Retorna a quantidade de partidas cadastradas.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return partidaService.CountAll();
	}

	@Operation(summary = "Adiciona uma nova partida.")
	@PostMapping
	public String Add(@RequestBody Partida partida) {
		partidaService.Add(partida);
		return "Partida cadastrada com sucesso.";
	}

	@Operation(summary = "Remove uma partida através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public String Remove(@PathVariable Integer id) {
		partidaService.Delete(id);
		return "Partida excluída com sucesso.";
	}
}
