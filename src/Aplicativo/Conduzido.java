package Aplicativo;

import Enumeracoes.Localizacao;

public class Conduzido extends Pessoa {

	private boolean emViagem = false;
	private double dinheiroParaCombustivel;
	private Localizacao localizacaoBairro;

	public Conduzido() {
		super();
	}

	public Conduzido(String nome, int idade, String celular, String rg,
			String cpf, String facebook) {
		super(nome, idade, celular, rg, cpf, facebook);
	}

	public Conduzido(double dinheiroParaCombustivel, String nome, int idade, String celular, String rg, String cpf,
			String facebook, Localizacao localizacaoBairro) {
		super(nome, idade, celular, rg, cpf, facebook);
		this.dinheiroParaCombustivel = dinheiroParaCombustivel;
		this.localizacaoBairro = localizacaoBairro;
	}

	public void acionarPolicia() {
		System.out.println("Ligando para Policia...\nPolicia acionada!");

	}
	
	public void sairDoCarro(double valorPagar) {
		this.setEmViagem(false);
		System.out.println("O conduzido(a) " + this.getNome() + " chegou a sua localização e esta pagando a viajem no valor de: " + valorPagar + " e esta saindo do carro.");
		this.setDinheiroParaCombustivel(this.getDinheiroParaCombustivel() - valorPagar);
	}
	//Precisa Terminar
	public void mostraConduzidos() {
		System.out.println("Conduzido: ");
		super.mostraPessoa();
		System.out.println("Dinheiro para Combustível: " + this.getDinheiroParaCombustivel());
		System.out.println("Destino: " + this.getLocalizacaoBairro());
		if(this.isEmViagem()) {
			System.out.println("Está em viagem");
		}
		else {
			System.out.println("Não está em viagem");
		}
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
	
//	public void validaDadosConduzido() {
//		System.out.print("Validando Dados do Conduzido...");
//		super.validaDados();
//	}
	
	public Localizacao getLocalizacaoBairro() {
		return localizacaoBairro;
	}

	public void setLocalizacaoBairro(Localizacao localizacaoBairro) {
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
