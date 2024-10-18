package br.edu.infnet.leonardo.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Time {
	private String nome;
	private String sigla;
	private String escudo;
	private List<Jogador> jogadores;
	
	public Time(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
		this.jogadores = new ArrayList<Jogador>();
	}
	
    @Override
    public String toString() {
    	return String.format("Time: %s - Quantidade de jogadores: %d", this.nome, this.jogadores.size());
    }
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getEscudo() {
		return escudo;
	}
	
	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
}