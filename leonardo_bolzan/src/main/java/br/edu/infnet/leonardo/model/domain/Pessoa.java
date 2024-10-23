package br.edu.infnet.leonardo.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "TPessoas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private int idade;

	@Override
    public String toString() {
    	return String.format("Pessoa: %s.", this.nome);
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
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
