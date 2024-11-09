package com.samzubeli.literalura.utilidades;

import java.util.Scanner;

public class ItensUteis {
	private static Scanner ler = new Scanner(System.in);

	public static void exibirMenu() {
		while (true) {
			System.out.println("escolha uma das opções abaixo\n".toUpperCase());
			System.out.println("1. buscar livro pelo título".toUpperCase());
			System.out.println("2. listar livros registrados".toUpperCase());
			System.out.println("3. listar autores registrados".toUpperCase());
			System.out.println("4. listar autores vivos em um determinado ano".toUpperCase());
			System.out.println("5. listar livros por idioma".toUpperCase());
			System.out.println("0. sair".toUpperCase());
			int opcao = ler.nextInt();
			ler.nextLine();
			if (opcao == 0)
				break;
			
			switch (opcao) {

			case 1:
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
}
