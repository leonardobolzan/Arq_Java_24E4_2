package br.edu.infnet.leonardo.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TNarradores")
public class Narrador extends Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String especialidade;
	private boolean disponivel;

	public Narrador() {
	}

	public Narrador(String nome, String especialidade) {
		this.setNome(nome);
		this.setEspecialidade(especialidade);
		this.setDisponivel(true);
	}

	@Override
	public String toString() {
		return String.format("Narrador: %s.", this.getNome());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
