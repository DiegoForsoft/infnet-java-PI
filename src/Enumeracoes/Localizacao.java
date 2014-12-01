package Enumeracoes;

public enum Localizacao {
	TIJUCA(10), ROCINHA(20), MEIER(30), LINS(40), LEME(50), LEBLON(60), CENTRO(70), CASADOLP(666);
	
	private double valorDaViagem;
	
	private void setValorLocalizacao(double vl) {
		this.valorDaViagem = vl;
	}
	
	public double getValorLocalizacao() {
		return this.valorDaViagem;
	}
	
	private Localizacao(double vl) {
		this.setValorLocalizacao(vl);
	}
}
