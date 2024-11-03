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

import br.edu.infnet.leonardo.model.domain.Narrador;
import br.edu.infnet.leonardo.model.service.NarradorService;

@RestController
public class NarradorController {

	@Autowired
	private NarradorService narradorService;

	@GetMapping(value = "/narradores")
	public Collection<Narrador> GetAll() {
		return narradorService.GetAll();
	}

	@GetMapping(value = "/narradores/{id}")
	public Optional<Narrador> GetById(@PathVariable Integer id) {
		return narradorService.GetById(id);
	}

	@GetMapping(value = "/narradores/count")
	public Long CountAll() {
		return narradorService.CountAll();
	}

	@PostMapping(value = "/narradores/new")
	public String Add(@RequestBody Narrador narrador) {
		narradorService.Add(narrador);
		return "Narrador cadastrado com sucesso.";
	}

	@DeleteMapping(value = "/narradores/{id}")
	public String Remove(@PathVariable Integer id) {
		narradorService.Delete(id);
		return "Narrador excluído com sucesso.";
	}
}
