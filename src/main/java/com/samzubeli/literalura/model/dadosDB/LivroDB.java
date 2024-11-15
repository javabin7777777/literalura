package com.samzubeli.literalura.model.dadosDB;

import com.samzubeli.literalura.model.Livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="livro_db")
public class LivroDB {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idLivro;
	@Column(unique = true)
	private String nomeLivro;		
	private String idioma;
	private Integer numeroDownloads;
	
	@ManyToOne()
	private AutorDB autor; // Chave estrangeira	
	
	
	@Override
	public String toString() {
		return "LivroDB [idLivro=" + idLivro + ", nomeLivro=" + nomeLivro + ", idioma=" + idioma 
				+ "," + " numeroDownloads=" + numeroDownloads + "]";
	}

	public LivroDB(Livro livro) {
		super();
		this.nomeLivro = livro.getTitulo();
		this.idioma = livro.getIdioma().get(0);
		this.numeroDownloads = livro.getNumeroDownloads();		
	}
	
	public LivroDB() {
		super();
	}

	public AutorDB getAutor() {
		return autor;
	}

	public void setAutor(AutorDB autor) {
		this.autor = autor;
	}	

	public String getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(String idLivro) {
		this.idLivro = idLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Integer getNumeroDownloads() {
		return numeroDownloads;
	}

	public void setNumeroDownloads(Integer numeroDownloads) {
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