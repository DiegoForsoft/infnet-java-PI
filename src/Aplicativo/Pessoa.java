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

	
	protected Pessoa() {
		super();
	}

	protected Pessoa(String nome, int idade, String celular, String rg,
			String cpf, String facebook) {

		this.setNome(nome);
		this.setIdade(idade);
		this.setCelular(celular);
		this.setRg(rg);
		this.setCpf(cpf);
		this.setFacebook(facebook);
	}

	public void publicarNoFacebook() {
		System.out.println("Foi publicado no facebook do usuario: "+ this.getNome());
	}

	public boolean validaIdade(int idade) {
		if (idade < 100 && idade > 0) {
			return true;
		}

		else {
			return false;
		}

	}
	
	public boolean isEmViagem() {
		return emViagem;
	}

	public void setEmViagem(boolean emViagem) {
		this.emViagem = emViagem;
	}

	public boolean validaCPF(String cpf) {
		if ((cpf.length() < 15) && (cpf.charAt(3) == '.') && (cpf.charAt(7) == '.') && (cpf.charAt(11) == '-')) {
			return true;
		} 
		else {
			return false;
		}

	}

	public boolean validaRG(String rg) {
		if ((rg.length() < 13) && (rg.charAt(2) == '.')
				&& (rg.charAt(6) == '.') && (rg.charAt(10) == '-')) {
			return true;

		} else {
			return false;
		}
	}

	public boolean validaCelular(String celular) {
		return celular.matches("^\\W\\d\\d\\W\\d\\d\\d\\d\\d\\W\\d\\d\\d\\d"); 
	}
	
	public boolean validaFacebook(String facebook) {
		return facebook.matches("[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+");
	}
	
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

	public void atualizarDados(String nome, int idade, String celular,
			String rg, String cpf, String facebook) {
		this.setNome(nome);
		this.setIdade(idade);
		this.setCelular(celular);
		this.setRg(rg);
		this.setCpf(cpf);
		this.setFacebook(facebook);
	}

	public boolean validaNome(String nome) {
		return nome.matches("(?i)[a-z]+");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (this.validaNome(nome) == true) {
			this.nome = nome;
		}
		else {
			System.out.println("Nome invalido.\n");
			this.nome = "-1";
		}
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (this.validaIdade(idade) == true) {
			this.idade = idade;
		} else {
			System.out.println("Idade invalida.\n");
			this.idade = -1;
		}
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		if (this.validaCelular(celular) == true) {
			this.celular = celular;
		} 
		else {
			System.out.println("Celular invalido.\n");
			this.celular = "-1";
		}
	}

	public String getRg() {
		return RG;
	}

	public void setRg(String rg) {
		if (this.validaRG(rg) == true) {
			this.RG = rg;
		} 
		else {
			System.out.println("RG invalido.\n");
			this.RG = "-1";
		}
	}

	public String getCpf() {
		return CPF;
	}

	public void setCpf(String cpf) {
		if (this.validaCPF(cpf) == true) {
			this.CPF = cpf;
		} 
		else {
			System.out.println("CPF invalido.\n");
			this.CPF = "-1";
		}
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		if (this.validaFacebook(facebook) == true) {
			this.facebook = facebook;
		} 
		else {
			System.out.println("Facebook invalido.\n");
			this.facebook = "-1";
		}
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	public static boolean validaDados(Pessoa objRecebido)
	{
		if(objRecebido.validaNome(objRecebido.getNome())) {
			if(objRecebido.validaCelular(objRecebido.getCelular())) {
				if(objRecebido.validaCPF(objRecebido.getCpf())) {
					if(objRecebido.validaIdade(objRecebido.getIdade())) {
						if(objRecebido.validaRG(objRecebido.getRg())) {
							if(objRecebido.validaFacebook(objRecebido.getFacebook())) {
								System.out.print("Todos os Dados s�o V�lidos, ");
								return true;
							}
							else {
								System.out.println("Facebook inv�lido");
								return false;
							}
						}
						else {
							System.out.println("RG inv�lido");
							return false;
						}
					}
					else {
						System.out.println("Idade inv�lida");
						return false;
					}
				}
				else {
					System.out.println("CPF inv�lido");
					return false;
				}
			}
			else {
				System.out.println("Celular inv�lido");
				return false;
			}
		}
		else {
			System.out.println("Nome inv�lido");
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result
				+ ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((RG == null) ? 0 : RG.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Pessoa other = (Pessoa) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
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
		if (RG == null) {
			if (other.RG != null)
				return false;
		} else if (!RG.equals(other.RG))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", celular="
				+ celular + ", rg=" + RG + ", cpf=" + CPF + ", facebook="
				+ facebook + ", localizacaoBairro=" + ", status=" + status + "]";
	}
	
	public void mostraPessoa() {
		System.out.println("Nome: " + this.getNome());
		System.out.println("Idade: " + this.getIdade());
		System.out.println("Celular: " + this.getCelular());
		System.out.println("RG: " + this.getRg());
		System.out.println("CPF: " + this.getCpf());
		System.out.println("Facebook: " + this.getFacebook());
	}

}
