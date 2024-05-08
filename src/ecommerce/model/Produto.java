package ecommerce.model;

public abstract class Produto {

	private int id;
	private float valor;
	private int qnt;
	private int tipo;
	private String nome;

	public Produto(int id, String nome, float valor, int qnt, int tipo) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.qnt = qnt;
		this.tipo = tipo;

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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {

		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Produto Físico";
			break;
		case 2:
			tipo = "Produto Digital";
			break;
		}

		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do Produto:");
		System.out.println("***********************************************************");
		System.out.println("Identificador ou ID: " + this.id);
		System.out.println("Nome do Produto: " + this.nome);
		System.out.println("Valor: " + valor);
		System.out.println("Quantidade: " + this.qnt);
		System.out.println("Tipo do Produto: " + this.tipo);

	}

}
