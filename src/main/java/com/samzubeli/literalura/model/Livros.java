package com.samzubeli.literalura.model;

import java.util.ArrayList;
import java.util.List;

public class Livros {
	
	//private List<String> resultado = new ArrayList<>();		
	private String titulo;
	private List<Autores> autor = new ArrayList<>();
	private List<String> idioma = new ArrayList<>();
	private Integer numeroDownloads; 
	
	public Livros(Resultados resultado) {
		super();
		this.titulo = resultado.titulo();
		this.autor = resultado.autor();
		this.idioma = resultado.idioma();
		this.numeroDownloads = resultado.numeroDownloads();
	}

	

	@Override
	public String toString() {
		return "Livros [titulo=" + titulo + ", autor=" + autor + ", idioma=" + idioma + ","
				+ " numeroDownloads=" + numeroDownloads + "]";
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Autores> getAutor() {
		return autor;
	}

	public void setAutor(List<Autores> autor) {
		this.autor = autor;
	}

	public List<String> getIdioma() {
		return idioma;
	}

	public void setIdioma(List<String> idioma) {
		this.idioma = idioma;
	}

	public Integer getNumeroDownloads() {
		return numeroDownloads;
	}

	public void setNumeroDownloads(Integer numeroDownloads) {
		this.numeroDownloads = numeroDownloads;
	}	
	
}
