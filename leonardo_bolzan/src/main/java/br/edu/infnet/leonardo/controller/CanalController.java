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

import br.edu.infnet.leonardo.model.domain.Canal;
import br.edu.infnet.leonardo.model.service.CanalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Canais", description = "Métodos disponíveis para a gestão dos canais de transmissão das partidas.")
@RestController
@RequestMapping("/canais")
public class CanalController {

	@Autowired
	private CanalService canalService;

	@Operation(summary = "Retorna todos os canais cadastrados.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso."),
			@ApiResponse(responseCode = "500", description = "Erro inesperado.") })
	@GetMapping
	public Collection<Canal> GetAll() {
		return canalService.GetAll();
	}

	@Operation(summary = "Retorna um canal através do identificador único.")
	@GetMapping(value = "/{id}")
	public Optional<Canal> GetById(@PathVariable Integer id) {
		return canalService.GetById(id);
	}

	@Operation(summary = "Retorna a quantidade de canais cadastrados.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return canalService.CountAll();
	}

	@Operation(summary = "Adiciona um novo canal.")
	@PostMapping
	public String Add(@RequestBody Canal canal) {
		canalService.Add(canal);
		return "Canal cadastrado com sucesso.";
	}

	@Operation(summary = "Remove um canal através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public String Remove(@PathVariable Integer id) {
		canalService.Delete(id);
		return "Canal excluído com sucesso.";
	}
}
