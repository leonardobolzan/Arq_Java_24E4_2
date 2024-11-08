package br.edu.infnet.leonardo.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TPartidas")
public class Partida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idTimeCasa")
	private Time timeCasa;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idTimeVisitante")
	private Time timeVisitante;

	@NotBlank(message = "O local da partida é uma informação obrigatória.")
	private String local;
	private int placarCasa;
	private int placarVisitante;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idEstatisticasCasa")
	private Estatisticas estatisticasTimeCasa;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idEstatisticasVisitante")
	private Estatisticas estatisticasTimeVisitante;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idPartida")
	private List<Canal> canais;

	public Partida() {
	}

	public Partida(Time timeCasa, Time timeVisitante, String local) {
		this.timeCasa = timeCasa;
		this.timeVisitante = timeVisitante;
		this.local = local;
		this.placarCasa = 0;
		this.placarVisitante = 0;
		this.estatisticasTimeCasa = new Estatisticas();
		this.estatisticasTimeVisitante = new Estatisticas();
		this.canais = new ArrayList<Canal>();
	}

	@Override
	public String toString() {
		return String.format("Partida entre os times %s e %s.", this.timeCasa.getNome(), this.timeVisitante.getNome());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Time getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}

	public Time getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getPlacarCasa() {
		return placarCasa;
	}

	public void setPlacarCasa(int placarCasa) {
		this.placarCasa = placarCasa;
	}

	public int getPlacarVisitante() {
		return placarVisitante;
	}

	public void setPlacarVisitante(int placarVisitante) {
		this.placarVisitante = placarVisitante;
	}

	public Estatisticas getEstatisticasTimeCasa() {
		return estatisticasTimeCasa;
	}

	public void setEstatisticasTimeCasa(Estatisticas estatisticasTimeCasa) {
		this.estatisticasTimeCasa = estatisticasTimeCasa;
	}

	public Estatisticas getEstatisticasTimeVisitante() {
		return estatisticasTimeVisitante;
	}

	public void setEstatisticasTimeVisitante(Estatisticas estatisticasTimeVisitante) {
		this.estatisticasTimeVisitante = estatisticasTimeVisitante;
	}

	public List<Canal> getCanais() {
		return canais;
	}

	public void setCanais(List<Canal> canais) {
		this.canais = canais;
	}

	public void addCanal(Canal canal) {
		this.canais.add(canal);
	}
}
