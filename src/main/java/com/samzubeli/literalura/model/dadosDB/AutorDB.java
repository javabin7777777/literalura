package com.samzubeli.literalura.model.dadosDB;

import java.util.ArrayList;
import java.util.List;

import com.samzubeli.literalura.model.Autores;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="autor_db")
public class AutorDB {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String idAutor;	
	@Column(unique=true)
	private String nomeAutor;
	private Integer anoNascimento;
	private Integer anoFalecimento;	
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LivroDB> livro = new ArrayList<>();		
	
	
	@Override
	public String toString() {
		return "AutorDB [idAutor=" + idAutor + ", nomeAutor=" + nomeAutor + ", anoNascimento=" + anoNascimento
				+ ", anoFalecimento=" + anoFalecimento +  "]";
	}

	public AutorDB(Autores autor) {
		super();		
		this.nomeAutor = autor.nome();
		this.anoNascimento = autor.anoNascimento();
		this.anoFalecimento = autor.anoFalecimento();		
	}
	
	public AutorDB() {
		super();
	}

	public List<LivroDB> getLivro() {
		return livro;
	}

	public void setLivro(List<LivroDB> livro) {
		this.livro = livro;
	}	

	public String getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(String idAutor) {
		this.idAutor = idAutor;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public Integer getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(Integer anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public Integer getAnoFalecimento() {
		return anoFalecimento;
	}

	public void setAnoFalecimento(Integer anoFalecimento) {
		this.anoFalecimento = anoFalecimento;
	}
}
