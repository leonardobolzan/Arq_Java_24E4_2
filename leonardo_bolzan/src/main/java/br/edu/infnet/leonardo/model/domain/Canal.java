package br.edu.infnet.leonardo.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TCanais")
public class Canal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private int numero;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idNarrador")
	private Narrador narrador;

	public Canal() {
	}

	public Canal(String nome, int numero, Narrador narrador) {
		this.nome = nome;
		this.numero = numero;
		this.narrador = narrador;
	}

	@Override
	public String toString() {
		return String.format("Canal: %s.", this.nome);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Narrador getNarrador() {
		return narrador;
	}

	public void setNarrador(Narrador narrador) {
		this.narrador = narrador;
	}
}
