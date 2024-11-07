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

import br.edu.infnet.leonardo.model.domain.Estatisticas;
import br.edu.infnet.leonardo.model.service.EstatisticasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Estatísticas", description = "Métodos disponíveis para a gestão das estatísticas das partidas.")
@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

	@Autowired
	private EstatisticasService estatisticasService;

	@Operation(summary = "Retorna todas as estatísticas cadastradas.")
	@GetMapping
	public ResponseEntity<Collection<Estatisticas>> GetAll() {
		return ResponseEntity.ok(estatisticasService.GetAll());
	}

	@Operation(summary = "Retorna uma estatística através do identificador único.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Estatisticas> GetById(@PathVariable Integer id) {
		Estatisticas estatisticas = estatisticasService.GetById(id);
		return estatisticas != null ? ResponseEntity.ok(estatisticas) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Operation(summary = "Retorna a quantidade de estatísticas cadastradas.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return estatisticasService.CountAll();
	}

	@Operation(summary = "Adiciona uma nova estatística.")
	@PostMapping
	public String Add(@RequestBody Estatisticas estatisticas) {
		estatisticasService.Add(estatisticas);
		return "Estatísticas cadastradas com sucesso.";
	}

	@Operation(summary = "Remove uma estatística através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public String Remove(@PathVariable Integer id) {
		estatisticasService.Delete(id);
		return "Estatísticas excluídas com sucesso.";
	}
}
