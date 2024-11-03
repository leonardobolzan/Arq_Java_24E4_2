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

import br.edu.infnet.leonardo.model.domain.Partida;
import br.edu.infnet.leonardo.model.service.PartidaService;

@RestController
public class PartidaController {

	@Autowired
	private PartidaService partidaService;
	
	@GetMapping(value = "/partidas")
	public Collection<Partida> GetAll(){
		return partidaService.GetAll();
	}
	
	@GetMapping(value = "/partidas/{id}")
	public Optional<Partida> GetById(@PathVariable Integer id){
		return partidaService.GetById(id);
	}
	
	@GetMapping(value = "/partidas/count")
	public Long CountAll(){
		return partidaService.CountAll();
	}
	
	@PostMapping(value = "/partidas/new")
	public String Add(@RequestBody Partida partida) {
		partidaService.Add(partida);
		return "Partida cadastrada com sucesso.";
	}
	
	@DeleteMapping(value = "/partidas/{id}")
	public String Remove(@PathVariable Integer id) {
		partidaService.Delete(id);
		return "Partida excluída com sucesso.";
	}
}
