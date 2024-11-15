package com.samzubeli.literalura.utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.samzubeli.literalura.model.DadosDoLivro;
import com.samzubeli.literalura.model.IDIOMA;
import com.samzubeli.literalura.model.Livro;
import com.samzubeli.literalura.model.dadosDB.AutorDB;
import com.samzubeli.literalura.model.dadosDB.LivroDB;
import com.samzubeli.literalura.model.dadosDB.repository.IAutorDBRepository;
import com.samzubeli.literalura.model.dadosDB.repository.ILivroDBRepository;
import com.samzubeli.literalura.servico.ConsultarApi;
import com.samzubeli.literalura.servico.FiltrarDados;

public class ItensUteis {
	private static Scanner ler = new Scanner(System.in);
	private static String endereco = "http://gutendex.com/books/?search="; //"http://gutendex.com/books/?search=dom+casmurro";
	private static String str = "";	
	private final static String mensagemA = "\n não há livros e autores,localmente\n";
	
	public static void exibirMenu(ConsultarApi buscar, FiltrarDados filtro, 
			 IAutorDBRepository repositoryAutor) {
		
		while (true) {
			System.out.println("\nescolha uma das opções abaixo".toUpperCase());
			System.out.println("    1. buscar livro pelo título na api web".toUpperCase());
			System.out.println("    2. listar livros registrados,local".toUpperCase());
			System.out.println("    3. listar autores registrados,local".toUpperCase());
			System.out.println("    4. listar autores vivos em um determinado ano,local".toUpperCase());
			System.out.println("    5. listar livros por idioma,local".toUpperCase());
			System.out.println("    0. sair".toUpperCase());
			int opcao = ler.nextInt();
			ler.nextLine();
			if (opcao == 0)
				break;
			
			switch (opcao) {

			case 1: 
				cadastrarLivro (buscar, filtro, repositoryAutor);				
				break;
			case 2:
				 System.out.println(listarLivros(repositoryAutor));				
				break;
			case 3:
				System.out.println(listarAutores(repositoryAutor));
				break;
			case 4:
				listarAutoresVivos(repositoryAutor);
				break;
			case 5:
				listarLivrosPorIdioma(repositoryAutor);
				break;
			}
		}
	}
	
	private static void cadastrarLivro(ConsultarApi buscar,FiltrarDados filtro, 
			 IAutorDBRepository repositoryAutor) {
		
		System.out.println("\n    entre com o nome do livro".toUpperCase()
				+" *( nomes compostos,favor usar como separador,o espaço ) ");
		String livroNome = ler.nextLine();
		livroNome = livroNome.replace(" ","+");		
		endereco = endereco.concat(livroNome);	
		str = buscar.obterDados(endereco);
		DadosDoLivro dadosDoLivro = filtro.obterDados(str, DadosDoLivro.class);
		Livro livro = new Livro(dadosDoLivro.resultado().get(0));		
		System.out.println("\nLivro= "+ livro);
		System.out.println();
		LivroDB livroDB = new LivroDB(livro);				
		AutorDB autor = new AutorDB(livro.getAutor().get(0));
		livroDB.setAutor(autor);		
		autor.getLivro().add(livroDB);
		repositoryAutor.save(autor);
		System.out.println();
		System.out.println("lista AutorDB = "+autor);
		System.out.println();
		System.out.println("lista LivroDB = "+autor.getLivro());			
	}
	
	private static List<List<LivroDB>> listarLivros(IAutorDBRepository repository) {
		List<AutorDB> lista  = repository.findAll();
		if(!lista.isEmpty()) {
			List<List<LivroDB>> listaDeLivros = lista.stream()
												.map(elemento -> elemento.getLivro())
												.collect(Collectors.toList());
			return listaDeLivros;
		} 
		System.out.println(mensagemA.toUpperCase());
		return null;
	}
	
	private static List<AutorDB> listarAutores(IAutorDBRepository repository) {
		List<AutorDB> listaDeAutores = repository.findAll();
		if(listaDeAutores.isEmpty()) {			
			System.out.println(mensagemA.toUpperCase());
			return null;
		}			
		return listaDeAutores;
	}
	
	private static void listarAutoresVivos(IAutorDBRepository repository) {	
		List<AutorDB> lista  = repository.findAll();
		if(!lista.isEmpty()) {
			Date dataAtual = new Date();
			DateFormat simple = new SimpleDateFormat("yyyy");
			Integer anoAtual = Integer.parseInt(simple.format(dataAtual));			
			List<AutorDB> listaDeAutores = 
					lista.stream()												
					.filter(autor -> anoAtual - autor.getAnoNascimento()<121)
					.collect(Collectors.toList());
			
			if(!listaDeAutores.isEmpty()) 
				System.out.println("\n lista de autores vivos \n".toUpperCase()
						+listaDeAutores+"\n");
			else 
				System.out.println("\n não existem autores vivos\n".toUpperCase());
			
			
		} else System.out.println(mensagemA.toUpperCase());		
	}
	
	private static void listarLivrosPorIdioma(IAutorDBRepository repository) {
		
		List<AutorDB> lista  = repository.findAll();
		if(lista.isEmpty()) {
			System.out.println(mensagemA.toUpperCase());			
		} else {			
			 List<String> idiomas = lista.stream()
					.flatMap(autor -> autor.getLivro().stream())
					.map(livro -> livro.getIdioma())
					.collect(Collectors.toList());
			System.out.println("\nentre com o idioma".toUpperCase()+" *(ex: pt para português)");
			String idioma = ler.nextLine();			
			if(idiomas.contains(idioma)) {				
				System.out.println("\nlivros com idioma "
						.toUpperCase()+IDIOMA.fromString(idioma)+"\n");
				lista.stream()
				.flatMap(autor -> autor.getLivro().stream()
				.filter(livro -> livro.getIdioma().equalsIgnoreCase(idioma)))
				.forEach(System.out::println);			
			} else 
				System.out.println("\n não há livros com o idioma "
						.toUpperCase()+IDIOMA.fromString(idioma)
				+" ,localmente\n".toUpperCase());
		}
	}
}

