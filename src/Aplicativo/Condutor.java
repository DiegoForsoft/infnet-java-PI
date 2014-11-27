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
			Localizacao localizacaoBairro) {
		this.CNH = cNH;
		this.veiculo = veiculo;
		this.nome = nome;
		this.idade = idade;
		this.celular = celular;
		this.rg = rg;
		this.cpf = cpf;
		this.facebook = facebook;
		this.localizacaoBairro = localizacaoBairro;
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
			System.out.println("Impossivel remover um veiculo que não está cadastrado.\n");
		}
	}
}
