package ecommerce.model;

public class ProdutoDigital extends Produto{
	
	private int chaveDigital;

	public ProdutoDigital(int id,  String nome, float valor, int qnt, int tipo, int chaveDigital) {
		super(id, nome, valor, qnt, tipo);
		this.chaveDigital = chaveDigital;
	}

	public int getChaveDigital() {
		return chaveDigital;
	}

	public void setChaveDigital(int chaveDigital) {
		this.chaveDigital = chaveDigital;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Chave Digital: "+ this.chaveDigital);
	}

}
