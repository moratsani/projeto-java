package ecommerce.model;

public class Cliente {
	
	private int id;
	private String nome;
	
	public Cliente(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void visualizarCliente() {
		System.out.println("Clientes: ");
		System.out.println("ID do cliente: "+this.id);
		System.out.println("Nome do cliente: "+this.nome);
	}
	

}
