package ecommerce.repository;

import ecommerce.model.Cliente;
import ecommerce.model.Produto;

public interface ECommerceRepository {

	// CRUD dos Produtos

	public void cadastrar(Produto produto);

	public void listarTodos();

	public void consultaPorID(int id);

	public void atualizar(Produto produto);

	public void deletar(int id);

	// Métodos do Menu
	public void carrinho(int id, float valor);

	public void visualizarHistorico(int id, float valor);

	// CRUD Cliente
	public void cadastroCliente(Cliente cliente);

	public void listarCliente();

	public void atualizarCliente(Cliente cliente);

	public void deletarCliente(int id);

}
