package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Cliente;
import ecommerce.model.Produto;
import ecommerce.repository.ECommerceRepository;

public class ECommerceController implements ECommerceRepository {

	private ArrayList<Produto> listarTodos = new ArrayList<Produto>();
	private ArrayList<Cliente> listarTodosClientes = new ArrayList<Cliente>();
	private ArrayList<Produto> carrinho = new ArrayList<Produto>();
	int idCliente = 0;
	int id = 0;

	@Override
	public void cadastrar(Produto produto) {
		listarTodos.add(produto);
		System.out.println("\nO produto id: " + produto.getId() + " foi cadastrado com sucesso! ");

	}

	@Override
	public void listarTodos() {
		for (var produto : listarTodos) {
			produto.visualizar();
		}

	}

	@Override
	public void consultaPorID(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null)
			produto.visualizar();
		else
			System.out.println("O produto id: " + id + " ainda não existe ou não foi encontrado!");

	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(id);

		if (buscaProduto != null) {
			listarTodos.set(listarTodos.indexOf(buscaProduto), produto);
			System.out.println("O produto id: " + produto.getId() + "foi atualizado com sucesso!");
		} else
			System.out.println("O produto id: " + produto.getId() + " não foi encontrado!");

	}

	@Override
	public void deletar(int id) {
		var produto = buscarNaCollection(id);

		if (produto != null) {
			if (listarTodos.remove(produto) == true)
				System.out.println("\nO produto id: " + id + " foi deletado com sucesso!");
		} else
			System.out.println("\nO produto id: " + id + " não foi encontrado!");
	}
	
	@Override
	public void cadastroCliente(Cliente cliente) {
		listarTodosClientes.add(cliente);
		System.out.println("\nO cliente id: " + cliente.getId() + " foi cadastrado com sucesso! ");
		
	}

	@Override
	public void listarCliente() {
		for (var cliente : listarTodosClientes) {
			cliente.visualizarCliente();
		}
		
	}

	@Override
	public void atualizarCliente(Cliente cliente) {
		var buscaCliente = buscarNaCollectionCliente(idCliente);

		if (buscaCliente != null) {
			listarTodosClientes.set(listarTodosClientes.indexOf(buscaCliente), cliente);
			System.out.println("O cliente id: " + cliente.getId() + " foi atualizado com sucesso!");
		} else
			System.out.println("O cliente id: " + cliente.getId() + " não foi encontrado!");
		
	}

	@Override
	public void deletarCliente(int idCliente) {
		var cliente = buscarNaCollectionCliente(idCliente);

		if (cliente != null) {
			if (listarTodosClientes.remove(cliente) == true)
				System.out.println("\nO cliente id: " + idCliente + " foi deletado com sucesso!");
		} else
			System.out.println("\nO cliente id: " + idCliente + " não foi encontrado!");
		
	}
	

	@Override
	public void carrinho(int id, float valorTotal) {
		var produto = buscarNaCollection(id);
		carrinho.add(produto);

	}

	@Override
	public void visualizarHistorico(int id, float valor) {
		float valorTotal = 0;
		
		carrinho.forEach(produto -> produto.visualizar());
		
		for(Produto produto : carrinho) {
			valorTotal += produto.getValor();
		}
		System.out.println("\n\nValor total do carrinho: "+valorTotal);
	}

	public int gerarID() {
		return ++id;
	}
	
	public int gerarIDCliente() {
		return ++idCliente;
	}

	public Produto buscarNaCollection(int id) {
		for (var produto : listarTodos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}
	
	public Cliente buscarNaCollectionCliente(int idCliente) {
		for (var cliente: listarTodosClientes) {
			if (cliente.getId() == idCliente) {
				return cliente;
			}
		}
		return null;
		
	}

}