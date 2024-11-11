package com.samzubeli.literalura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LivroPersitir {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idLivro;
	@Column(unique = true)
	private String nomeLivro;		
	private String idioma;
	private Integer numeroDownloads;
}

/* @Column("novonome")  troca o nome do atributo da classe.A coluna na terá será nomeada novonome
 	@Table ("novonometabela") troca o nome da classe,que será nomeada novonometabela na tabela 
 	correspondente a classe no SGBD.
 	@Enumerated(EnumType.STRING) Para atributo tipo Enum.
 */