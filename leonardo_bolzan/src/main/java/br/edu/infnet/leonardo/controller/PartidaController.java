package br.edu.infnet.leonardo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
