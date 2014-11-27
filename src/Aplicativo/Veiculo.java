package Aplicativo;

import java.util.List;
import java.util.Scanner;
import Enumeracoes.StatusEnum;

import Enumeracoes.CorDoCarro;

public class Veiculo {

	private String numeroDaPlaca;
	private CorDoCarro cor;
	
	private int quantidadeDeVagas;

	private boolean validaPlacaDeCarro(String placa) {
		return placa.matches("[A-Z]{3}-\\d{4}");
	}

	public void exibirVeiculo() {
		this.toString();
	}
	
	public boolean validaVagas() {
		
		if ( (this.getQuantidadeDeVagas()) > 0) {
			this.setQuantidadeDeVagas(this.getQuantidadeDeVagas() - 1);
			return true;
		}
		
		else {
			return false;
		}
		
	}

	public String getNumeroDaPlaca() {
		return numeroDaPlaca;
	}

	public void setNumeroDaPlaca(String numeroDaPlaca) {
		if (this.validaPlacaDeCarro(numeroDaPlaca) == true) {
			this.numeroDaPlaca = numeroDaPlaca;
		} else {
			this.numeroDaPlaca = "-1";
		}
	}

	public CorDoCarro getCor() {
		return this.cor;
	}

	public void setCor(CorDoCarro cor) {
		this.cor = cor;
		System.out.println("A cor: " + this.getCor() + " foi escolhida\n");
	}

	

	private boolean validaQuantidadeDeCombustivel(double qt) {
		if (qt > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getQuantidadeDeVagas() {
		return quantidadeDeVagas;
	}

	public void setQuantidadeDeVagas(int quantidadeDeVagas) {
		this.quantidadeDeVagas = quantidadeDeVagas;
	}

	@Override
	public String toString() {
		return "Veiculo [numeroDaPlaca=" + numeroDaPlaca + ", cor=" + cor
				+ ", quantidadeDeCombustivel=" + ", quantidadeDeVagas="+ quantidadeDeVagas + "]";
	}

	public Veiculo(String numeroDaPlaca, CorDoCarro cor, int quantidadeDeVagas) {
		this.numeroDaPlaca = numeroDaPlaca;
		this.cor = cor;
		this.quantidadeDeVagas = quantidadeDeVagas;
	}
	
}
