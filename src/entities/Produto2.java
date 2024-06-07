package entities;

public class Produto2 extends Produtos {
	
	private Double produto1;
	
	public Produto2(int restricao1, int restricao2, double lucroTotal) {
		super(restricao1, restricao2, lucroTotal);
	}

	public Double getProduto1() {
		return this.produto1;
	}
	public void setProduto1(double produto1) {
		this.produto1 = produto1;
	}
	
	@Override
	public Double getPrimeiraComparacao(int totalDisponivel, int totalTempo, Produtos produto) {
		return (double) (totalDisponivel - this.getRestricao1() * produto1) / produto.getRestricao1();
	}

	@Override
	public Double getSegundaComparacao(int totalDisponivel, Produtos produto) {
		return 0.0;
	}

	@Override
	public Double getTerceiraComparacao(int totalDisponivel, Produtos produto) {
		return 0.0;
	}

	@Override
	public Double getQuartaComparacao(int totalDisponivel, Produtos produto) {
		return 0.0;
	}

	@Override
	public Double getQuintaComparacao(int totalDisponivel, Produtos produto) {
		return 0.0;
	}

	@Override
	public Double getSextaComparacao(int totalDisponivel, Produtos produto) {
		return 0.0;
	}
	
	
}
