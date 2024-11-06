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
	public Collection<Jogador> GetAll() {
		return jogadorService.GetAll();
	}

	@Operation(summary = "Retorna um jogador através do identificador único.")
	@GetMapping(value = "/{id}")
	public Optional<Jogador> GetById(@PathVariable Integer id) {
		return jogadorService.GetById(id);
	}

	@Operation(summary = "Retorna a quantidade de jogadores cadastrados.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return jogadorService.CountAll();
	}

	@Operation(summary = "Adiciona um novo jogador.")
	@PostMapping
	public String Add(@RequestBody Jogador jogador) {
		jogadorService.Add(jogador);
		return "Jogador cadastrado com sucesso.";
	}

	@Operation(summary = "Remove um jogador através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public String Remove(@PathVariable Integer id) {
		jogadorService.Delete(id);
		return "Jogador excluído com sucesso.";
	}
}
