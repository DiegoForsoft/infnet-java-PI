package Aplicativo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Enumeracoes.Localizacao;
import Banco.Dados;


public class Condutor extends Pessoa {

	private String CNH;
	private Veiculo veiculo;
	private List<Localizacao> localizacoes;

	public Condutor() {
		super();
	}

	public Condutor(String nome, int idade, String celular, String rg,
			String cpf, String facebook) {
		super(nome, idade, celular, rg, cpf, facebook);
	}

	public Condutor(String cNH, Veiculo veiculo, String nome, int idade,
			String celular, String rg, String cpf, String facebook, List<Localizacao> localizacaoRecebida) {
		super(nome, idade, celular, rg, cpf, facebook);
		this.CNH = cNH;
		this.veiculo = veiculo;
		this.localizacoes = localizacaoRecebida;
	}
	
	public Condutor(String cNH, Veiculo veiculo, String nome, int idade,
			String celular, String rg, String cpf, String facebook) {
		super(nome, idade, celular, rg, cpf, facebook);
		this.CNH = cNH;
		this.veiculo = veiculo;
	}

	public boolean validaCNH(String CNH) {
		if(CNH.matches("\\d{11}") == true) {
			return true;
		}
		else {
			return false;
		}
	}

	public void atualizarDados(String cNH, Veiculo veiculo, String nome,
			int idade, String celular, String rg, String cpf, String facebook,
			ArrayList <Localizacao> localizacaoBairro) {
		this.CNH = cNH;
		this.veiculo = veiculo;
		this.nome = nome;
		this.idade = idade;
		this.celular = celular;
		this.rg = rg;
		this.cpf = cpf;
		this.facebook = facebook;
		this.localizacoes = localizacaoBairro;
	}
	
	public void mostraCondutor() {
		System.out.println("Condutor: ");
		super.mostraPessoa();
		System.out.println("CNH: " + this.getCNH());
		System.out.println("\nLocalizações: ");
		for(Localizacao l: localizacoes) {
			System.out.println("Localização por onde irá passar: " + l.name());
		}
		veiculo.mostraVeiculo();
	}
	
	public void validaDadosCondutor() {
		System.out.print("Validando Dados do Condutor...");
		super.validaDados();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CNH == null) ? 0 : CNH.hashCode());
		result = prime * result
				+ ((localizacoes == null) ? 0 : localizacoes.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Condutor other = (Condutor) obj;
		if (CNH == null) {
			if (other.CNH != null)
				return false;
		} else if (!CNH.equals(other.CNH))
			return false;
		if (localizacoes == null) {
			if (other.localizacoes != null)
				return false;
		} else if (!localizacoes.equals(other.localizacoes))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

	public List<Localizacao> getLocalizacoes() {
		return localizacoes;
	}

	public void setLocalizacoes(List<Localizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}

	public String getCNH() {
		return CNH;
	}
	
	public void setCNH(String CNH) {
		if(this.validaCNH(CNH) == true) {
			this.CNH = CNH;
		}
		else {
			this.CNH = "-1";
			System.out.println("CNH invalido.");
		}
		
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void removerVeiculo() {	
		if(veiculo != null) {
			this.veiculo = null;
		}
		else {
			System.out.println("Impossivel remover um veiculo que nÃ£o estÃ¡ cadastrado.\n");
		}
	}
}
