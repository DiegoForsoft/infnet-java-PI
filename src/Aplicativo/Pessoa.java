package Aplicativo;

import Enumeracoes.*;

public abstract class Pessoa {

	protected String nome;
	protected int idade;
	protected String celular;
	protected String RG;
	protected String CPF;
	protected String facebook;
	protected StatusEnum status;
	protected boolean emViagem = false;

	/**
	 * Construtor vazio de pessoa como protected para ser herdado nas classes conduzidos e condutores
	 */
	protected Pessoa() {
		super();
	}
	
	/**
	 * Construtor com os atributos que devem e podem ser iniciados instanciando o mesmo, 
	 * pois, as outras informações são armazenadas durante os processos do sistema, 
	 * também como protected para ser herdado nas classes conduzidos e condutores
	 * @param nome
	 * @param idade
	 * @param celular
	 * @param rg
	 * @param cpf
	 * @param facebook
	 */
	protected Pessoa(String nome, int idade, String celular, String rg,
			String cpf, String facebook) {

		this.setNome(nome);
		this.setIdade(idade);
		this.setCelular(celular);
		this.setRg(rg);
		this.setCpf(cpf);
		this.setFacebook(facebook);
	}
	
	/**
	 * Método que mostra um pequeno exemplo de que haveria uma publicação no facebook de tal usuário que ele está utilizando nosso aplicativo.
	 */
	public void publicarNoFacebook() {
		System.out.println("Foi publicado no facebook do usuario: "+ this.getNome());
	}
	
	/**
	 * Valida a idade da pessoa
	 * @param idade
	 * @return
	 */
	public boolean validaIdade(int idade) {
		if (idade < 100 && idade > 0) {
			return true;
		}

		else {
			return false;
		}

	}
	
	/**
	 * Valida o cpf da pessoa comparando seus caracteres em determinadas posições
	 * @param cpf
	 * @return
	 */
	public boolean validaCPF(String cpf) {
		if ((cpf.length() < 15) && (cpf.charAt(3) == '.') && (cpf.charAt(7) == '.') && (cpf.charAt(11) == '-')) {
			return true;
		} 
		else {
			return false;
		}

	}
	
	/**
	 * Valida o RG da pessoa comparando seus caracteres em determinadas posições
	 * @param rg
	 * @return
	 */
	public boolean validaRG(String rg) {
		if ((rg.length() < 13) && (rg.charAt(2) == '.')
				&& (rg.charAt(6) == '.') && (rg.charAt(10) == '-')) {
			return true;

		} else {
			return false;
		}
	}
	
	/**
	 * Foi realizado validação por expressão regular, foi validado se está neste formato
	 * @param celular
	 * @return
	 */
	public boolean validaCelular(String celular) {
		return celular.matches("^\\W\\d\\d\\W\\d\\d\\d\\d\\d\\W\\d\\d\\d\\d"); 
	}
	
	/**
	 * Foi realizado validação por expressão regular, foi validado se está neste formato
	 * @param facebook
	 * @return
	 */
	public boolean validaFacebook(String facebook) {
		return facebook.matches("[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+");
	}
	/**
	 * Pontua uma determinanda pessoa de acordo com a avaliação da viagem, foi utilizado Enumerações.
	 * @param i
	 * @param obj
	 * @return
	 */
	public boolean pontuarPessoa(int i, Pessoa obj) {
		if (i >= 0 && i <= 10) {
			if (i >= 0 && i <= 2) {
				obj.setStatus(StatusEnum.LP);
			} 
			else if (i > 2 && i <= 4) {
				obj.setStatus(StatusEnum.RUIM);
			}
			else if (i > 4 && i <= 6) {
				obj.setStatus(StatusEnum.MEDIO);
			} 
			else if (i > 6 && i <= 8) {
				obj.setStatus(StatusEnum.BOM);
			} 
			else if (i > 8 && i <= 10) {
				obj.setStatus(StatusEnum.EXCELENTE);
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Atualiza os dados de uma determinada pessoa
	 * @param nome
	 * @param idade
	 * @param celular
	 * @param rg
	 * @param cpf
	 * @param facebook
	 */
	public void atualizarDados(String nome, int idade, String celular,
			String rg, String cpf, String facebook) {
		this.setNome(nome);
		this.setIdade(idade);
		this.setCelular(celular);
		this.setRg(rg);
		this.setCpf(cpf);
		this.setFacebook(facebook);
	}
	/**
	 * Foi realizado validação por expressão regular, foi validado se está neste formato
	 * @param nome
	 * @return
	 */
	public boolean validaNome(String nome) {
		return nome.matches("(?i)[a-z]+");
	}
	/**
	 * Depois que os dados são entrados no sistema este método valida-os e informa a pessoa se estão certos
	 * @param objRecebido
	 * @return
	 */
	public static boolean validaDados(Pessoa objRecebido)
	{
		if(objRecebido.validaNome(objRecebido.getNome())) {
			if(objRecebido.validaCelular(objRecebido.getCelular())) {
				if(objRecebido.validaCPF(objRecebido.getCpf())) {
					if(objRecebido.validaIdade(objRecebido.getIdade())) {
						if(objRecebido.validaRG(objRecebido.getRg())) {
							if(objRecebido.validaFacebook(objRecebido.getFacebook())) {
								System.out.print("Todos os Dados são Válidos, ");
								return true;
							}
							else {
								System.out.println("Facebook inválido");
								return false;
							}
						}
						else {
							System.out.println("RG inválido");
							return false;
						}
					}
					else {
						System.out.println("Idade inválida");
						return false;
					}
				}
				else {
					System.out.println("CPF inválido");
					return false;
				}
			}
			else {
				System.out.println("Celular inválido");
				return false;
			}
		}
		else {
			System.out.println("Nome inválido");
			return false;
		}
	}
	
	/**
	 * Mostra uma determinada pessoa
	 */
	public void mostraPessoa() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Idade: " + this.getIdade());
		System.out.println("Celular: " + this.getCelular());
		System.out.println("RG: " + this.getRg());
		System.out.println("CPF: " + this.getCpf());
		System.out.println("Facebook: " + this.getFacebook());
	}
	
	// Getters and Setters
	public boolean isEmViagem() {
		return emViagem;
	}
	// Getters and Setters
	public void setEmViagem(boolean emViagem) {
		this.emViagem = emViagem;
	}
	// Getters and Setters
	public String getNome() {
		return nome;
	}
	// Getters and Setters
	public void setNome(String nome) {
		if (this.validaNome(nome) == true) {
			this.nome = nome;
		}
		else {
			System.out.println("Nome invalido.\n");
			this.nome = "-1";
		}
	}
	// Getters and Setters
	public int getIdade() {
		return idade;
	}
	// Getters and Setters
	public void setIdade(int idade) {
		if (this.validaIdade(idade) == true) {
			this.idade = idade;
		} else {
			System.out.println("Idade invalida.\n");
			this.idade = -1;
		}
	}
	// Getters and Setters
	public String getCelular() {
		return celular;
	}
	// Getters and Setters
	public void setCelular(String celular) {
		if (this.validaCelular(celular) == true) {
			this.celular = celular;
		} 
		else {
			System.out.println("Celular invalido.\n");
			this.celular = "-1";
		}
	}
	// Getters and Setters
	public String getRg() {
		return RG;
	}
	// Getters and Setters
	public void setRg(String rg) {
		if (this.validaRG(rg) == true) {
			this.RG = rg;
		} 
		else {
			System.out.println("RG invalido.\n");
			this.RG = "-1";
		}
	}
	
	// Getters and Setters
	public String getCpf() {
		return CPF;
	}
	
	// Getters and Setters
	public void setCpf(String cpf) {
		if (this.validaCPF(cpf) == true) {
			this.CPF = cpf;
		} 
		else {
			System.out.println("CPF invalido.\n");
			this.CPF = "-1";
		}
	}
	// Getters and Setters
	public String getFacebook() {
		return facebook;
	}
	// Getters and Setters
	public void setFacebook(String facebook) {
		if (this.validaFacebook(facebook) == true) {
			this.facebook = facebook;
		} 
		else {
			System.out.println("Facebook invalido.\n");
			this.facebook = "-1";
		}
	}
	// Getters and Setters
	public StatusEnum getStatus() {
		return status;
	}
	// Getters and Setters
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	/**
	 * Foi feito para debugs
	 */
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", celular="
				+ celular + ", RG=" + RG + ", CPF=" + CPF + ", facebook="
				+ facebook + ", status=" + status + ", emViagem=" + emViagem
				+ "]";
	}

	/**
	 * Foi usado foi usado apra comparação, pois usamos hashSet
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((RG == null) ? 0 : RG.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + (emViagem ? 1231 : 1237);
		result = prime * result
				+ ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	/**
	 * O equals foi utilizado como comparação
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (RG == null) {
			if (other.RG != null)
				return false;
		} else if (!RG.equals(other.RG))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (emViagem != other.emViagem)
			return false;
		if (facebook == null) {
			if (other.facebook != null)
				return false;
		} else if (!facebook.equals(other.facebook))
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	

}
