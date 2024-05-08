package ecommerce.model;

public class ProdutoFisico extends Produto{
	
	private int lote;

	public ProdutoFisico(int id, String nome, float valor, int qnt, int tipo, int lote) {
		super(id, nome, valor, qnt, tipo);
		this.lote = lote;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Lote Produto Físico: "+ this.lote);
	}
	
	

}
