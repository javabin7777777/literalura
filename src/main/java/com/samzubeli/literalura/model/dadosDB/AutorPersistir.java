package com.samzubeli.literalura.model.dadosDB;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AutorPersistir {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String IdAutor;	
	@Column(unique=true)
	private String nomeAutor;
	private Integer anoNascimento;
	private Integer anoFalecimento;
	
	public AutorPersistir(String idAutor, String nomeAutor, Integer anoNascimento, 
			Integer anoFalecimento) {
		super();
		IdAutor = idAutor;
		this.nomeAutor = nomeAutor;
		this.anoNascimento = anoNascimento;
		this.anoFalecimento = anoFalecimento;
	}
	
	
}
