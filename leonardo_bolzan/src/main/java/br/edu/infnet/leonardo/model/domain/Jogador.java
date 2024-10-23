package br.edu.infnet.leonardo.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TJogadores")
public class Jogador extends Pessoa {
	private int numero;
	private String posicao;
	private Boolean titular;

	@ManyToOne
	@JoinColumn(name = "idTime")
	private Time time;
	
	public Jogador(String nome, int numero, String posicao) {
		this.setNome(nome);
		this.setNumero(numero);
		this.setPosicao(posicao);
		this.setTitular(true);
	}
	
    @Override
    public String toString() {
    	return String.format("Jogador: %s - Número: %d.", this.getNome(), this.numero);
    }
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getPosicao() {
		return posicao;
	}
	
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	public Boolean getTitular() {
		return titular;
	}
	
	public void setTitular(Boolean titular) {
		this.titular = titular;
	}
}
