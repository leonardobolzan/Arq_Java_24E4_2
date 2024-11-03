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

import br.edu.infnet.leonardo.model.domain.Estatisticas;
import br.edu.infnet.leonardo.model.service.EstatisticasService;

@RestController
public class EstatisticasController {

	@Autowired
	private EstatisticasService estatisticasService;

	@GetMapping(value = "/estatisticas")
	public Collection<Estatisticas> GetAll() {
		return estatisticasService.GetAll();
	}

	@GetMapping(value = "/estatisticas/{id}")
	public Optional<Estatisticas> GetById(@PathVariable Integer id) {
		return estatisticasService.GetById(id);
	}

	@GetMapping(value = "/estatisticas/count")
	public Long CountAll() {
		return estatisticasService.CountAll();
	}

	@PostMapping(value = "/estatisticas/new")
	public String Add(@RequestBody Estatisticas estatisticas) {
		estatisticasService.Add(estatisticas);
		return "Estatísticas cadastradas com sucesso.";
	}

	@DeleteMapping(value = "/estatisticas/{id}")
	public String Remove(@PathVariable Integer id) {
		estatisticasService.Delete(id);
		return "Estatísticas excluídas com sucesso.";
	}
}
