package Aplicativo;

import java.util.ArrayList;

import Enumeracoes.Localizacao;
import Enumeracoes.StatusEnum;
import Aplicativo.Condutor;

public class Conduzido extends Pessoa {

	private boolean emViagem = false;
	private double dinheiroParaCombustivel;

	public Conduzido() {
		super();
	}

	public Conduzido(String nome, int idade, String celular, String rg,
			String cpf, String facebook, Localizacao localizacaoBairro) {
		super(nome, idade, celular, rg, cpf, facebook, localizacaoBairro);
	}

	public Conduzido(double dinheiroParaCombustivel, String nome, int idade, String celular, String rg, String cpf,
			String facebook, Localizacao localizacaoBairro) {
		super(nome, idade, celular, rg, cpf, facebook, localizacaoBairro);
		this.dinheiroParaCombustivel = dinheiroParaCombustivel;
	}

	public void acionarPolicia() {
		System.out.println("Ligando para Policia...\nPolicia acionada!");

	}
	
	public void sairDoCarro(double valorPagar) {
		this.setEmViagem(false);
		this.setDinheiroParaCombustivel(this.getDinheiroParaCombustivel() - valorPagar);
	}
	
	public void mostraConduzidos() {
		System.out.println(this.getNome());
		System.out.println(this.getIdade());
		System.out.println(this.getCelular());
		System.out.println(this.getRg());
		System.out.println(this.getCpf());
		System.out.println(this.getFacebook());
		System.out.println(this.getDinheiroParaCombustivel());
	}
	
	public void atualizarDados(double dinheiroParaCombustivel, String nome,
			int idade, String celular, String rg, String cpf, String facebook,
			Localizacao localizacaoBairro) {
		this.dinheiroParaCombustivel = dinheiroParaCombustivel;
		this.nome = nome;
		this.idade = idade;
		this.celular = celular;
		this.rg = rg;
		this.cpf = cpf;
		this.facebook = facebook;
		this.localizacaoBairro = localizacaoBairro;
	}
	
	public boolean isEmViagem() {
		return emViagem;
	}

	public void setEmViagem(boolean emViagem) {
		this.emViagem = emViagem;
	}

	public double getDinheiroParaCombustivel() {
		return dinheiroParaCombustivel;
	}

	public void setDinheiroParaCombustivel(double dinheiroParaCombustivel) {
		this.dinheiroParaCombustivel = dinheiroParaCombustivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(dinheiroParaCombustivel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!super.equals(obj)) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Conduzido other = (Conduzido) obj;
		if (Double.doubleToLongBits(dinheiroParaCombustivel) != Double
				.doubleToLongBits(other.dinheiroParaCombustivel)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "Conduzido [emViagem=" + emViagem + ", dinheiroParaCombustivel="
				+ dinheiroParaCombustivel + ", nome=" + nome + ", idade="
				+ idade + ", celular=" + celular + ", rg=" + rg + ", cpf="
				+ cpf + ", facebook=" + facebook + ", localizacaoBairro="
				+ localizacaoBairro + ", status=" + status + "]";
	}

	

}
