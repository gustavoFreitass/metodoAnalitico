package entities;

public class Produto1 extends Produtos {

	public Produto1(int restricao1, int restricao2, double lucroTotal) {
		super(restricao1, restricao2, lucroTotal);
	}

	
	@Override
	public Double getPrimeiraComparacao(int totalDisponivel, int totalTempo, Produtos produto) {
		return (double) (totalTempo - (this.getRestricao2() / this.getRestricao1()) * totalDisponivel) 
				/ (produto.getRestricao2() - (this.getRestricao2() / this.getRestricao1()) * produto.getRestricao1());
	}

}
