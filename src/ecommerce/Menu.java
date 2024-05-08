package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);

		int selecao;

		while (true) {

			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                     E - COMMERCE                    ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("      1 - Criar Cadastro de Produto                  ");
			System.out.println("      2 - Listar todos os Produtos                   ");
			System.out.println("      3 - Consultar Produtos por ID                  ");
			System.out.println("      4 - Atualizar Dados do Cadastro de Produto     ");
			System.out.println("      5 - Apagar Cadastro de Produto                 ");
			System.out.println("      6 - Carrinho de Produtos                       ");
			System.out.println("      7 - Visualizar histórico de compras            ");
			System.out.println("      8 - Cadastrar cliente                          ");
			System.out.println("      9 - Atualizar dados do cliente                 ");
			System.out.println("      10 - Sair                                      ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");

			try {
				selecao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				selecao = 0;
			}

			switch (selecao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Cadastro de Produto\n\n");

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n\n");

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar Produtos por ID\n\n");

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar Dados do Cadastro de Produto\n\n");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar Cadastro de produto\n\n");

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Carrinho de Produtos\n\n");

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Visualizar histórico de compras\n\n");

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Cadastrar cliente\n\n");

				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados do cliente\n\n");

				keyPress();
				break;
			case 10:
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nE-commerce");
				sobre();
				leia.close();
				System.exit(0);
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {
		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Eliana Morato - liamorato@hotmail.com");
		System.out.println("github.com/moratsani");
		System.out.println("*********************************************************");
	}
}
