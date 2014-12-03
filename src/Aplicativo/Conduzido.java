package Aplicativo;

import Enumeracoes.Localizacao;

public class Conduzido extends Pessoa {

	private double dinheiroParaCombustivel;                                   // Atributo onde mostra que o condutor possui dinheiro e paga o combustível
	private Localizacao localizacaoBairro;									  // Localição de destino final do conduzido

	/**
	 * Construtor vazio de Conduzido
	 */
	public Conduzido() {
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
	public Conduzido(String nome, int idade, String celular, String rg,
			String cpf, String facebook) {
		super(nome, idade, celular, rg, cpf, facebook);
	}
	
	/**
	 * Construtor com todas as informações que devem e podem ser iniciados instanciando o mesmo, 
	 * pois, as outras informações são armazenadas durante os processos do sistema, está herdando pelo super do construtor de pessoa
	 * @param dinheiroParaCombustivel
	 * @param nome
	 * @param idade
	 * @param celular
	 * @param rg
	 * @param cpf
	 * @param facebook
	 * @param localizacaoBairro
	 */
	public Conduzido(double dinheiroParaCombustivel, String nome, int idade, String celular, String rg, String cpf,
			String facebook, Localizacao localizacaoBairro) {
		super(nome, idade, celular, rg, cpf, facebook);
		this.dinheiroParaCombustivel = dinheiroParaCombustivel;
		this.localizacaoBairro = localizacaoBairro;
	}
	
	/**
	 * Aqui está sendo feito uma demonstração que aciona a polícia em caso de qualquer problema que possa acontecer durante a viagem
	 */
	public void acionarPolicia() {
		System.out.println("Ligando para Policia...\nPolicia acionada!");

	}
	/**
	 * A pessoa chega na sua localização, sai do carro e paga o dinheiro da viagem. 
	 * Altera o Emviagem para false e diminui dinheiro para combustível pelo valor a pagar
	 * @param valorPagar
	 */
	public void sairDoCarro(double valorPagar) {
		this.setEmViagem(false);
		System.out.println("O conduzido(a) " + this.getNome() + " chegou a sua localização e esta pagando a viagem no valor de: " + valorPagar + " e esta saindo do carro.");
		this.setDinheiroParaCombustivel(this.getDinheiroParaCombustivel() - valorPagar);
	}
	
	/**
	 * Mostra um determinado conduzido, esse método foi sobreescrito da classe pessoa adicionando a validação se ele está em viagem
	 */
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
	
	/**
	 * Atualiza os dados de um determinado conduzido, esse método foi sobreescrito da classe pessoa adicionando seus próprios atributos
	 * @param dinheiroParaCombustivel
	 * @param nome
	 * @param idade
	 * @param celular
	 * @param rg
	 * @param cpf
	 * @param facebook
	 * @param localizacaoBairro
	 */
	public void atualizarDados(double dinheiroParaCombustivel, String nome,
			int idade, String celular, String rg, String cpf, String facebook,
			Localizacao localizacaoBairro) {
		super.atualizarDados(nome, idade, celular, rg, cpf, facebook);
		this.dinheiroParaCombustivel = dinheiroParaCombustivel;
		this.localizacaoBairro = localizacaoBairro;
		System.out.println("Conduzido(a) " + this.nome + " atualizou seus dados");
	}
	// Getters and Setters
	public Localizacao getLocalizacaoBairro() {
		return localizacaoBairro;
	}
	// Getters and Setters
	public void setLocalizacaoBairro(Localizacao localizacaoBairro) {
		this.localizacaoBairro = localizacaoBairro;
	}
	// Getters and Setters
	public double getDinheiroParaCombustivel() {
		return dinheiroParaCombustivel;
	}
	// Getters and Setters
	public void setDinheiroParaCombustivel(double dinheiroParaCombustivel) {
		this.dinheiroParaCombustivel = dinheiroParaCombustivel;
	}
	
	/**
	 * Foi feito para debugs
	 */
	@Override
	public String toString() {
		return "Conduzido [dinheiroParaCombustivel=" + dinheiroParaCombustivel
				+ ", localizacaoBairro=" + localizacaoBairro + "]";
	}
	
	/**
	 * Foi usado foi usado apra comparação, pois usamos hashSet
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(dinheiroParaCombustivel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime
				* result
				+ ((localizacaoBairro == null) ? 0 : localizacaoBairro
						.hashCode());
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
		Conduzido other = (Conduzido) obj;
		if (Double.doubleToLongBits(dinheiroParaCombustivel) != Double
				.doubleToLongBits(other.dinheiroParaCombustivel))
			return false;
		if (localizacaoBairro != other.localizacaoBairro)
			return false;
		return true;
	}

	
	
	
}
