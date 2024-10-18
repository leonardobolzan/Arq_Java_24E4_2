package br.edu.infnet.leonardo.model.domain;

public class Narrador extends Pessoa {
    private String especialidade;
    private boolean disponivel;
   
    public Narrador(String nome, String especialidade) {
        this.setNome(nome);
    	this.especialidade = especialidade;
        this.disponivel = true;
    }

    @Override
    public String toString() {
    	return String.format("Narrador: %s.", this.getNome());
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
