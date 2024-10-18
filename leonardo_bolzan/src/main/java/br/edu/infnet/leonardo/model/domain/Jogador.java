package br.edu.infnet.leonardo.model.domain;

public class Jogador extends Pessoa {
	private int numero;
	private String posicao;
	private Boolean titular;

	public Jogador(int numero, String posicao) {
		this.numero = numero;
		this.posicao = posicao;
		this.titular = true;
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
