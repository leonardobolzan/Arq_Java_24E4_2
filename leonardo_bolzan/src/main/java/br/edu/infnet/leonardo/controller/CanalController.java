package br.edu.infnet.leonardo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.leonardo.model.domain.Canal;
import br.edu.infnet.leonardo.model.service.CanalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Canais", description = "Métodos disponíveis para a gestão dos canais de transmissão das partidas.")
@RestController
@RequestMapping("/canais")
public class CanalController {

	@Autowired
	private CanalService canalService;

	@Operation(summary = "Retorna todos os canais cadastrados.")
	@GetMapping
	public ResponseEntity<Collection<Canal>> GetAll() {
		return ResponseEntity.ok(canalService.GetAll());
	}

	@Operation(summary = "Retorna um canal através do identificador único.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Canal> GetById(@PathVariable Integer id) {
		Canal canal = canalService.GetById(id);
		return canal != null ? ResponseEntity.ok(canal) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Operation(summary = "Retorna a quantidade de canais cadastrados.")
	@GetMapping(value = "/count")
	public Long CountAll() {
		return canalService.CountAll();
	}

	@Operation(summary = "Adiciona um novo canal.")
	@PostMapping
	public ResponseEntity<String> Add(@RequestBody Canal canal) {
		canalService.Add(canal);
		return ResponseEntity.status(HttpStatus.CREATED).body("Canal cadastrado com sucesso.");
	}

	@Operation(summary = "Atualiza um canal existente.")
	@PutMapping
	public ResponseEntity<Canal> Update(@RequestBody Canal canal) {
		canalService.Update(canal);
		return ResponseEntity.status(HttpStatus.CREATED).body(canal);
	}

	@Operation(summary = "Atualiza o nome de um canal existente.")
	@PatchMapping
	public ResponseEntity<Canal> UpdateNome(@RequestParam Integer id, String nome) {
		Canal canal = canalService.UpdateNome(id, nome);
		return ResponseEntity.status(HttpStatus.CREATED).body(canal);
	}

	@Operation(summary = "Remove um canal através do identificador único.")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> Remove(@PathVariable Integer id) {
		if (canalService.Delete(id)) {
			return ResponseEntity.ok("Canal excluído com sucesso.");
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
