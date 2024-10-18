package br.edu.infnet.leonardo.model.domain;

public class Canal {
	private String nome;
	private int numero;
	private Narrador narrador;
	
	public Canal(String nome, int numero, Narrador narrador) {
		this.nome = nome;
		this.numero = numero;
		this.narrador = narrador;
	}
	
    @Override
    public String toString() {
    	return String.format("Canal: %s.", this.nome);
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
