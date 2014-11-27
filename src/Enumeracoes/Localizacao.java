package Enumeracoes;

public enum Localizacao {
	TIJUCA(10), ROCINHA(20), MEIER(30), LINS(40), LEME(50), LEBLON(60), CENTRO(70), CASADOLP(666);
	
	private double valorDaViagem;
	
	private void setValorViagem(double vl) {
		this.valorDaViagem = vl;
	}
	
	public double getValorViagem() {
		return this.valorDaViagem;
	}
	
	private Localizacao(double vl) {
		this.setValorViagem(vl);
	}
}
