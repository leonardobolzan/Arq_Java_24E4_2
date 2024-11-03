package br.edu.infnet.leonardo.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TEstatisticas")
public class Estatisticas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private float percentualPosseBola;
	private int chutesAGol;
	private int faltasCometidas;
	private int cartoesAmarelos;
	private int cartoesVermelhos;

	public Estatisticas() {
		this.percentualPosseBola = 0;
		this.chutesAGol = 0;
		this.faltasCometidas = 0;
		this.cartoesAmarelos = 0;
		this.cartoesVermelhos = 0;
	}

	@Override
	public String toString() {
		return "Estatísticas da partida.";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPercentualPosseBola() {
		return percentualPosseBola;
	}

	public void setPercentualPosseBola(float percentualPosseBola) {
		this.percentualPosseBola = percentualPosseBola;
	}

	public int getChutesAGol() {
		return chutesAGol;
	}

	public void setChutesAGol(int chutesAGol) {
		this.chutesAGol = chutesAGol;
	}

	public int getFaltasCometidas() {
		return faltasCometidas;
	}

	public void setFaltasCometidas(int faltasCometidas) {
		this.faltasCometidas = faltasCometidas;
	}

	public int getCartoesAmarelos() {
		return cartoesAmarelos;
	}

	public void setCartoesAmarelos(int cartoesAmarelos) {
		this.cartoesAmarelos = cartoesAmarelos;
	}

	public int getCartoesVermelhos() {
		return cartoesVermelhos;
	}

	public void setCartoesVermelhos(int cartoesVermelhos) {
		this.cartoesVermelhos = cartoesVermelhos;
	}
}
