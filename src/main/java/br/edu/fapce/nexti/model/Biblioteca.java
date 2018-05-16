package br.edu.fapce.nexti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "biblioteca")
public class Biblioteca implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private List<PalavrasBiblioteca> palavras;
	
	public Biblioteca() {
		
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(mappedBy = "biblioteca", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<PalavrasBiblioteca> getPalavras() {
		return palavras;
	}

	public void setPalavras(List<PalavrasBiblioteca> palavras) {
		this.palavras = palavras;
	}
	
	
}
