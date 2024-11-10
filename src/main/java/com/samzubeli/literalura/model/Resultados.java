package com.samzubeli.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Resultados(
		@JsonAlias("title")String titulo,
		@JsonAlias("authors")List<autores> autor,
		@JsonAlias("languages")List<String> idioma, 
		@JsonAlias("download_count")Integer numeroDownloads) {
	
}
