package Aplicativo;

import java.util.ArrayList;
import java.util.List;

import Enumeracoes.Localizacao;


public class Condutor extends Pessoa {

	private String CNH;
	private Veiculo veiculo;
	private List<Localizacao> localizacoes;

	/**
	 * Construtor vazio de Conduzido
	 */
	public Condutor() {
		super();
	}
	
	/**
	 * Construtor com os atributos que devem e podem ser iniciados instanciando o mesmo, 
	 * pois, as outras informações são armazenadas durante os processos do sistema, está herdando pelo super do construtor de pessoa
	 * @param nome
	 * @param idade
	 * @param celular
	 * @param rg
	 * @param cpf
	 * @param facebook
	 */
	public Condutor(String nome, int idade, String celular, String rg,
			String cpf, String facebook) {
		super(nome, idade, celular, rg, cpf, facebook);
	}
	
	/**
	 * Construtor com todas as informações que devem e podem ser iniciados instanciando o mesmo, 
	 * pois, as outras informações são armazenadas durante os processos do sistema, está herdando pelo super do construtor de pessoa
	 * @param cNH
	 * @param veiculo
	 * @param nome
	 * @param idade
	 * @param celular
	 * @param rg
	 * @param cpf
	 * @param facebook
	 * @param localizacaoRecebida
	 */
	public Condutor(String cNH, Veiculo veiculo, String nome, int idade,
			String celular, String rg, String cpf, String facebook, List<Localizacao> localizacaoRecebida) {
		super(nome, idade, celular, rg, cpf, facebook);
		this.CNH = cNH;
		this.veiculo = veiculo;
		this.localizacoes = localizacaoRecebida;
	}
	
	/**
	 * Construtor com quase todas as informações, com exceção da localização que pode ser colocada em seguida após ser instanciado, 
	 * as outras informações são armazenadas durante os processos do sistema, está herdando pelo super do construtor de pessoa
	 * @param cNH
	 * @param veiculo
	 * @param nome
	 * @param idade
	 * @param celular
	 * @param rg
	 * @param cpf
	 * @param facebook
	 */
	public Condutor(String cNH, Veiculo veiculo, String nome, int idade,
			String celular, String rg, String cpf, String facebook) {
		super(nome, idade, celular, rg, cpf, facebook);
		this.CNH = cNH;
		this.veiculo = veiculo;
	}
	
	/**
	 * Foi realizado validação por expressão regular, foi validado se está neste formato
	 * @param CNH
	 * @return
	 */
	public boolean validaCNH(String CNH) {
		if(CNH.matches("\\d{11}") == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Atualiza os dados de um determinado condutor, esse método foi sobreescrito da classe pessoa adicionando seus próprios atributos
	 * @param cNH
	 * @param veiculo
	 * @param nome
	 * @param idade
	 * @param celular
	 * @param rg
	 * @param cpf
	 * @param facebook
	 * @param localizacaoBairro
	 */
	public void atualizarDados(String cNH, Veiculo veiculo, String nome,
			int idade, String celular, String rg, String cpf, String facebook,
			List <Localizacao> localizacaoBairro) {
		super.atualizarDados(nome, idade, celular, rg, cpf, facebook);
		this.CNH = cNH;
		this.veiculo = veiculo;
		this.localizacoes = localizacaoBairro;
		System.out.println("Condutor(a) " + this.nome + " atualizou seus dados");
	}
	/**
	 * Mostra um determinado conduzido, esse método foi sobreescrito da classe pessoa adicionando a validação se ele está em viagem
	 */
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
	
	// Getters and Setters
	public List<Localizacao> getLocalizacoes() {
		return localizacoes;
	}
	// Getters and Setters
	public void setLocalizacoes(List<Localizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}
	// Getters and Setters
	public String getCNH() {
		return CNH;
	}
	// Getters and Setters
	public void setCNH(String CNH) {
		if(this.validaCNH(CNH) == true) {
			this.CNH = CNH;
		}
		else {
			this.CNH = "-1";
			System.out.println("CNH invalido.");
		}
		
	}
	// Getters and Setters
	public Veiculo getVeiculo() {
		return veiculo;
	}
	// Getters and Setters
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	// Getters and Setters
	public void removerVeiculo() {	
		if(veiculo != null) {
			this.veiculo = null;
		}
		else {
			System.out.println("Impossivel remover um veiculo que nÃ£o estÃ¡ cadastrado.\n");
		}
	}
	
	/**
	 * Foi usado foi usado apra comparação, pois usamos hashSet
	 */
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

	/**
	 * O equals foi utilizado como comparação
	 */
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

	/**
	 * Foi feito para debugs
	 */
	@Override
	public String toString() {
		return "Condutor [CNH=" + CNH + ", veiculo=" + veiculo
				+ ", localizacoes=" + localizacoes + "]";
	}
}
