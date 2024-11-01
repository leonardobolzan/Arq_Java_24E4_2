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

import br.edu.infnet.leonardo.model.domain.Time;
import br.edu.infnet.leonardo.model.service.TimeService;

@RestController
public class TimeController {

	@Autowired
	private TimeService timeService;
	
	@GetMapping(value = "/times")
	public Collection<Time> GetAll(){
		return timeService.GetAll();
	}
	
	@GetMapping(value = "/times/{id}")
	public Optional<Time> GetById(@PathVariable Integer id){
		return timeService.GetById(id);
	}
	
	@PostMapping(value = "/times/new")
	public String Add(@RequestBody Time time) {
		timeService.Add(time);
		return "Time cadastrado com sucesso.";
	}
	
	@DeleteMapping(value = "/times/{id}")
	public String Remove(@PathVariable Integer id) {
		timeService.Delete(id);
		return "Time excluído com sucesso.";
	}
}
