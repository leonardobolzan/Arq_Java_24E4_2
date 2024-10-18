package br.edu.infnet.leonardo.model.domain;

public abstract class Pessoa {
	private String nome;
	private int idade;

    @Override
    public String toString() {
    	return String.format("Pessoa: %s.", this.nome);
    }
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
