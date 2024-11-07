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

import br.edu.infnet.leonardo.model.domain.Time;
import br.edu.infnet.leonardo.model.service.TimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Times", description = "Métodos disponíveis para a gestão dos times.")
@RestController
@RequestMapping("/times")
public class TimeController {

	@Autowired
	private TimeService timeService;

	@Operation(summary = "Retorna todos os times cadastrados.")
	@GetMapping
	public ResponseEntity<Collection<Time>> GetAll() {
		return ResponseEntity.ok(timeService.GetAll());
	}

	@Operation(summary = "Retorna um time através do identificador único.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Time> GetById(@PathVariable Integer id) {
		Time time = timeService.GetById(id);
		return time != null ? ResponseEntity.ok(time) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Operation(summary = "Retorna a quantidade de times cadastrados.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return timeService.CountAll();
	}

	@Operation(summary = "Adiciona um novo time.")
	@PostMapping
	public String Add(@RequestBody Time time) {
		timeService.Add(time);
		return "Time cadastrado com sucesso.";
	}

	@Operation(summary = "Remove um time através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public String Remove(@PathVariable Integer id) {
		timeService.Delete(id);
		return "Time excluído com sucesso.";
	}
}
