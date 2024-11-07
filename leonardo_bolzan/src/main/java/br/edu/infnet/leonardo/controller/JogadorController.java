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

import br.edu.infnet.leonardo.model.domain.Jogador;
import br.edu.infnet.leonardo.model.service.JogadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Jogadores", description = "Métodos disponíveis para a gestão dos jogadores dos times.")
@RestController
@RequestMapping("/jogadores")
public class JogadorController {

	@Autowired
	private JogadorService jogadorService;

	@Operation(summary = "Retorna todos os jogadores cadastrados.")
	@GetMapping
	public ResponseEntity<Collection<Jogador>> GetAll() {
		return ResponseEntity.ok(jogadorService.GetAll());
	}

	@Operation(summary = "Retorna um jogador através do identificador único.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Jogador> GetById(@PathVariable Integer id) {
		Jogador jogador = jogadorService.GetById(id);
		return jogador != null ? ResponseEntity.ok(jogador) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Operation(summary = "Retorna a quantidade de jogadores cadastrados.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return jogadorService.CountAll();
	}

	@Operation(summary = "Adiciona um novo jogador.")
	@PostMapping
	public ResponseEntity<String> Add(@RequestBody Jogador jogador) {
		jogadorService.Add(jogador);
		return ResponseEntity.status(HttpStatus.CREATED).body("Jogador cadastrado com sucesso.");
	}

	@Operation(summary = "Remove um jogador através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public String Remove(@PathVariable Integer id) {
		jogadorService.Delete(id);
		return "Jogador excluído com sucesso.";
	}
}
