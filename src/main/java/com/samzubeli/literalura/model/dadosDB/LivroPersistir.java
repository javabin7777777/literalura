package com.samzubeli.literalura.model.dadosDB;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LivroPersistir {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idLivro;
	@Column(unique = true)
	private String nomeLivro;		
	private String idioma;
	private Integer numeroDownloads;
	
	public LivroPersistir(String nomeLivro, List<String> idioma, Integer numeroDownloads) {
		super();
		this.nomeLivro = nomeLivro;
		this.idioma = idioma.get(0);
		this.numeroDownloads = numeroDownloads;
	}	
	
}

/* 
 	@Column("novonome")  troca o nome do atributo da classe.A coluna será nomeada novonome. 
 	@Table ("novonometabela") troca o nome da classe,que será nomeada novonometabela na tabela 
 	correspondente a classe no SGBD.
 	@Enumerated(EnumType.STRING) Para atributo tipo Enum.
 	@Transient Faz com o spring data jpa desconsidere o atributo com essa 'annotation' .
 */