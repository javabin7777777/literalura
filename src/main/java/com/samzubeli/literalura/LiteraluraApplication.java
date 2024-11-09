package com.samzubeli.literalura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samzubeli.literalura.model.DadosDoLivro;
import com.samzubeli.literalura.model.Livros;
import com.samzubeli.literalura.servico.ConsultarApi;
import com.samzubeli.literalura.servico.FiltrarDados;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		FiltrarDados filtro = new FiltrarDados();
		ConsultarApi buscar = new ConsultarApi();
		String endereco = "http://gutendex.com/books/?search=dom+casmurro";
		String strJson = buscar.obterDados(endereco);
		DadosDoLivro dadosDoLivro = filtro.obterDados(strJson, DadosDoLivro.class);
		System.out.println(dadosDoLivro);
		
	}

}
