package com.samzubeli.literalura.utilidades;

import java.util.Scanner;

import com.samzubeli.literalura.model.DadosDoLivro;
import com.samzubeli.literalura.model.Livros;
import com.samzubeli.literalura.servico.ConsultarApi;
import com.samzubeli.literalura.servico.FiltrarDados;

public class ItensUteis {
	private static Scanner ler = new Scanner(System.in);
	private static String endereco = "http://gutendex.com/books/?search="; //"http://gutendex.com/books/?search=dom+casmurro";
	private static String str = "";
	public static void exibirMenu(ConsultarApi buscar, FiltrarDados filtro) {
		while (true) {
			System.out.println("\nescolha uma das opções abaixo".toUpperCase());
			System.out.println("    1. buscar livro pelo título".toUpperCase());
			System.out.println("    2. listar livros registrados".toUpperCase());
			System.out.println("    3. listar autores registrados".toUpperCase());
			System.out.println("    4. listar autores vivos em um determinado ano".toUpperCase());
			System.out.println("    5. listar livros por idioma".toUpperCase());
			System.out.println("    0. sair".toUpperCase());
			int opcao = ler.nextInt();
			ler.nextLine();
			if (opcao == 0)
				break;
			
			switch (opcao) {

			case 1: 
				cadastrarLivro (buscar, filtro);
				;
				break;
			case 2:
				;
				break;
			case 3:
				;
				break;
			case 4:
				;
				break;
			case 5:
				;
				break;

			}
		}
	}

	private static void cadastrarLivro(ConsultarApi buscar,FiltrarDados filtro) {
		System.out.println("\n    entre com o nome do livro".toUpperCase()
				+" * nomes compostos,favor usar como separador,o espaço");
		String livroNome = ler.nextLine();
		livroNome = livroNome.replace(" ", "+");
		endereco = endereco.concat(livroNome); 
		str = buscar.obterDados(endereco);
		DadosDoLivro dadosDoLivro = filtro.obterDados(str, DadosDoLivro.class);
		Livros livro = new Livros(dadosDoLivro.resultado().get(0));
		System.out.println("\n livro\n".toUpperCase()+livro);
		System.out.println(livro.getAutor().get(0));
		System.out.println(livro.getAutor().get(0).nome());
		System.out.println(livro.getAutor().get(0).anoNascimento());
		System.out.println(livro.getAutor().get(0).anoFalecimento());		
	}
}
