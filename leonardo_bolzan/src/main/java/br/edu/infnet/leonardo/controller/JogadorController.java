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

import br.edu.infnet.leonardo.model.domain.Jogador;
import br.edu.infnet.leonardo.model.service.JogadorService;

@RestController
public class JogadorController {

	@Autowired
	private JogadorService jogadorService;

	@GetMapping(value = "/jogadores")
	public Collection<Jogador> GetAll() {
		return jogadorService.GetAll();
	}

	@GetMapping(value = "/jogadores/{id}")
	public Optional<Jogador> GetById(@PathVariable Integer id) {
		return jogadorService.GetById(id);
	}

	@GetMapping(value = "/jogadores/count")
	public Long CountAll() {
		return jogadorService.CountAll();
	}

	@PostMapping(value = "/jogadores/new")
	public String Add(@RequestBody Jogador jogador) {
		jogadorService.Add(jogador);
		return "Jogador cadastrado com sucesso.";
	}

	@DeleteMapping(value = "/jogadores/{id}")
	public String Remove(@PathVariable Integer id) {
		jogadorService.Delete(id);
		return "Jogador excluído com sucesso.";
	}
}
