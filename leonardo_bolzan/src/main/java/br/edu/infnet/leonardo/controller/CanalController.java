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

import br.edu.infnet.leonardo.model.domain.Canal;
import br.edu.infnet.leonardo.model.service.CanalService;

@RestController
public class CanalController {

	@Autowired
	private CanalService canalService;

	@GetMapping(value = "/canais")
	public Collection<Canal> GetAll() {
		return canalService.GetAll();
	}

	@GetMapping(value = "/canais/{id}")
	public Optional<Canal> GetById(@PathVariable Integer id) {
		return canalService.GetById(id);
	}

	@GetMapping(value = "/canais/count")
	public Long CountAll() {
		return canalService.CountAll();
	}

	@PostMapping(value = "/canais/new")
	public String Add(@RequestBody Canal canal) {
		canalService.Add(canal);
		return "Canal cadastrado com sucesso.";
	}

	@DeleteMapping(value = "/canais/{id}")
	public String Remove(@PathVariable Integer id) {
		canalService.Delete(id);
		return "Canal excluído com sucesso.";
	}
}
