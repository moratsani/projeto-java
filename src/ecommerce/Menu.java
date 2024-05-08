package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.ECommerceController;
import ecommerce.model.Cliente;
import ecommerce.model.ProdutoDigital;
import ecommerce.model.ProdutoFisico;
import ecommerce.util.Cores;

public class Menu {

	public static void main(String[] args) {
		ECommerceController produto = new ECommerceController();
		ECommerceController cliente = new ECommerceController();

		Scanner leia = new Scanner(System.in);

		int selecao, idProduto, idCliente, idCarrinho = 0, qnt, tipo, chaveDigital, lote;
		String nomeProduto, nomeCliente;
		float valor = 0f;

		ProdutoFisico fisico1 = new ProdutoFisico(produto.gerarID(), "Lápis", 2.00f, 10, 2, 1540);
		produto.cadastrar(fisico1);
		ProdutoDigital digital1 = new ProdutoDigital(produto.gerarID(), "Jogo Digital Pou", 50.00f, 47, 1, 1540187);
		produto.cadastrar(digital1);

		Cliente cliente1 = new Cliente(cliente.gerarIDCliente(), "Maria");
		cliente.cadastroCliente(cliente1);

		produto.listarTodos();
		cliente.listarCliente();

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
			System.out.println("      9 - Ver cliente cadastrado                     ");
			System.out.println("      10 - Atualizar dados do cliente                ");
			System.out.println("      11 - Excluir  cliente                          ");
			System.out.println("      12 - Sair                                      ");
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

			if (selecao == 12) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nE-commerce");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (selecao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Cadastro de Produto\n\n");

				System.out.println("Digite o nome do produto: ");
				leia.skip("\\R?");
				nomeProduto = leia.nextLine();

				do {
					System.out.println("Digite o Tipo do Produto (1 - Produto Digital - ou 2 - Produto Físico): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o valor do Produto (R$): ");
				valor = leia.nextFloat();

				System.out.println("Digite a quantidade do produto: ");
				qnt = leia.nextInt();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite a chave digital do produto: ");
					chaveDigital = leia.nextInt();
					produto.cadastrar(
							new ProdutoDigital(produto.gerarID(), nomeProduto, valor, qnt, tipo, chaveDigital));
				}
				case 2 -> {
					System.out.println("Digite o lote do produto: ");
					lote = leia.nextInt();
					produto.cadastrar(new ProdutoFisico(produto.gerarID(), nomeProduto, valor, qnt, tipo, lote));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n\n");
				produto.listarTodos();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar Produtos por ID\n\n");
				System.out.println("Digite o id do produto: ");
				idProduto = leia.nextInt();

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar Dados do Cadastro de Produto\n\n");
				System.out.println("Digite o id do produto: ");
				idProduto = leia.nextInt();

				var buscaProduto = produto.buscarNaCollection(idProduto);

				if (buscaProduto != null) {

					tipo = buscaProduto.getTipo();

					System.out.println("Digite o nome do produto:");
					leia.skip("\\R?");
					nomeProduto = leia.nextLine();

					System.out.println("Digite o valor do Produto (R$): ");
					valor = leia.nextFloat();

					System.out.println("Digite a quantidade do produto: ");
					qnt = leia.nextInt();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite a chave do produto: ");
						chaveDigital = leia.nextInt();

						produto.atualizar(new ProdutoDigital(idProduto, nomeProduto, valor, qnt, tipo, chaveDigital));

					}
					case 2 -> {
						System.out.println("Digite o lote do produto: ");
						lote = leia.nextInt();

						produto.atualizar(new ProdutoFisico(idProduto, nomeProduto, valor, qnt, tipo, lote));

					}
					default -> {
						System.out.println("Tipo de id inválido!");
					}
					}
				} else {
					System.out.println("O produto não foi encontrado!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar Cadastro de produto\n\n");

				System.out.println("Digite o id do produto: ");
				idProduto = leia.nextInt();

				produto.deletar(idProduto);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Carrinho de Produtos\n\n");
				System.out.println("Adicionar produto no carrinho: ");
				System.out.println("Digite o ID do produto: ");
				idProduto = leia.nextInt();

				produto.carrinho(idProduto, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Visualizar histórico de compras\n\n");
				produto.visualizarHistorico(idCarrinho, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Cadastrar cliente\n\n");

				System.out.println("Digite o nome do cliente: ");
				leia.skip("\\R?");
				nomeCliente = leia.nextLine();

				cliente.cadastroCliente(new Cliente(cliente.gerarID(), nomeCliente));

				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE + "Ver cliente cadastrado\n\n");
				cliente.listarCliente();

				keyPress();
				break;
			case 10:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados do cliente\n\n");
				System.out.println("Digite o id do cliente: ");
				idCliente = leia.nextInt();

				var buscaCliente = cliente.buscarNaCollectionCliente(idCliente);
				if (buscaCliente != null) {

					System.out.println("Digite o nome do Cliente:");
					leia.skip("\\R?");
					nomeCliente = leia.nextLine();

					cliente.atualizarCliente(new Cliente(idCliente, nomeCliente));

				} else {
					System.out.println("Tipo de id inválido!");
				}

				keyPress();
				break;

			case 11:
				System.out.println(Cores.TEXT_WHITE + "Excluir cliente\n\n");

				System.out.println("Digite o id do cliente: ");
				idCliente = leia.nextInt();

				cliente.deletarCliente(idCliente);

				keyPress();
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
