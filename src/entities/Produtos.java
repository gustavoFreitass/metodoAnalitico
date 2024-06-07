package entities;

public abstract class Produtos {
	
	private Integer restricao1;
	private Integer restricao2;
	private Double lucroTotal;
	
	public Produtos(int restricao1, int restricao2, double lucroTotal) {
		this.restricao1 = restricao1;
		this.restricao2 = restricao2;
		this.lucroTotal = lucroTotal;
	}
	
	public Integer getRestricao1() {
		return this.restricao1;
	}
	public void setRestricao1(int restricao1) {
		this.restricao1 = restricao1;
	}
	
	public Integer getRestricao2() {
		return this.restricao2;
	}
	public void setRestricao2(int restricao2) {
		this.restricao2 = restricao2;
	}
	
	public Double getLucroTotal() {
		return this.lucroTotal;
	}
	public void setLucroTotal(double lucroTotal) {
		this.lucroTotal = lucroTotal;
	}
	
	public abstract Double getPrimeiraComparacao(int totalDisponivel, int totalTempo, Produtos produto);
	
	public abstract Double getSegundaComparacao(int totalDisponivel, Produtos produto);
	
	public abstract Double getTerceiraComparacao(int totalDisponivel, Produtos produto);
	
	public abstract Double getQuartaComparacao(int totalDisponivel, Produtos produto);
	
	public abstract Double getQuintaComparacao(int totalDisponivel, Produtos produto);
	
	public abstract Double getSextaComparacao(int totalDisponivel, Produtos produto);
}
