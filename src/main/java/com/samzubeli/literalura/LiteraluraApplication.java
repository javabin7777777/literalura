package com.samzubeli.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samzubeli.literalura.model.dadosDB.repository.livroPersistirRepository;
import com.samzubeli.literalura.servico.ConsultarApi;
import com.samzubeli.literalura.servico.FiltrarDados;
import com.samzubeli.literalura.utilidades.ItensUteis;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	
	@Autowired
	private livroPersistirRepository repository;// Salvar dados no SGBD.
	
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		FiltrarDados filtro = new FiltrarDados();
		ConsultarApi buscar = new ConsultarApi();
		ItensUteis.exibirMenu(buscar, filtro, repository);
		System.out.println("\nterminou,tchau.".toUpperCase());
		/*
		String endereco = "http://gutendex.com/books/?search=dom+casmurro";
		String strJson = buscar.obterDados(endereco);
		System.out.println(strJson);
		DadosDoLivro dadosDoLivro = filtro.obterDados(strJson, DadosDoLivro.class);
		System.out.println(dadosDoLivro);		
		Livros livro = new Livros(dadosDoLivro.resultado().get(0));
		System.out.println("\n livro\n".toUpperCase()+livro);
		System.out.println(livro.getAutor().get(0));
		Autores autor = livro.getAutor().get(0);	
		System.out.println(autor.nome());
		System.out.println(livro.getAutor().get(0).nome());
		System.out.println("\nterminou,tchau.".toUpperCase());	
		*/	
	}

}
