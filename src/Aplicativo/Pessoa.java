package Aplicativo;

import Enumeracoes.*;

public abstract class Pessoa {

	protected String nome;
	protected int idade;
	protected String celular;
	protected String rg;
	protected String cpf;
	protected String facebook;
	protected StatusEnum status;

	protected Pessoa() {
		super();
	}

	protected Pessoa(String nome, int idade, String celular, String rg,
			String cpf, String facebook) {

		this.nome = nome;
		this.idade = idade;
		this.celular = celular;
		this.rg = rg;
		this.cpf = cpf;
		this.facebook = facebook;
	}

	public void publicarNoFacebook() {
		System.out.println("Foi publicado no facebook do usuario: "
				+ this.getNome());
	}

	public boolean validaIdade() {
		if (getIdade() < 100 && getIdade() > 0) {
			return true;
		}

		else {
			return false;
		}

	}

	// Est√° em avalia√ß√£o.
	// public ArrayList <Pessoa> pesquisarCarona(ArrayList <Condutor> a,
	// Conduzido c) {
	// ArrayList <Pessoa> b = new ArrayList<Pessoa>();
	// for(Pessoa pessoa: a)
	// {
	// if(pessoa.getLocalizacaoBairro() == c.getLocalizacaoBairro()){
	// b.add(pessoa);
	// }
	// }
	// if(b.size() > 0){
	// return b;
	// }
	// else{
	// return null;
	// }
	// }

	// public ArrayList <Pessoa> pesquisarCarona(ArrayList <Conduzido> a,
	// Condutor c) {
	// ArrayList <Pessoa> b = new ArrayList<Pessoa>();
	// for(Pessoa pessoa: a)
	// {
	// if(pessoa.getLocalizacaoBairro() == c.getLocalizacaoBairro()){
	// b.add(pessoa);
	// }
	// }
	// if(b.size() > 0){
	// return b;
	// }
	// else{
	// return null;
	// }
	// }

	// public boolean validaLocalizacao() {
	// boolean confirma = false;
	// localizacaoBairro.toLowerCase();
	// for(int i = 0; i < localizacaoBairro.length(); i++)
	// {
	// if((localizacaoBairro.charAt(i) >= 97) && (localizacaoBairro.charAt(i) <=
	// 122)){
	// confirma = true;
	// }
	// else{
	// confirma = false;
	// break;
	// }
	// }
	// if(confirma)
	// {
	// return true;
	// }
	// else
	// {
	// return false;
	// }
	//
	// }

	public boolean validaCPF() {
		if ((cpf.length() < 15) && (cpf.charAt(3) == '.')
				&& (cpf.charAt(7) == '.') && (cpf.charAt(11) == '-')) {
			return true;

		} else {
			return false;
		}

	}

	public boolean validaRG() {
		if ((rg.length() < 13) && (rg.charAt(2) == '.')
				&& (rg.charAt(6) == '.') && (rg.charAt(10) == '-')) {
			return true;

		} else {
			return false;
		}
	}

	public boolean validaCelular() {
		if ((celular.length() < 15) && (celular.charAt(0) == '(')
				&& (celular.charAt(3) == ')') && (celular.charAt(9) == '-')) {
			return true;
		} else {
			return false;
		}
	}
	
	//valida facebook ta dando merda.
	public boolean validaFacebook() {
		int aux = facebook.indexOf("@");
		int aux2 = facebook.indexOf(".com");
		if (aux > 0 && aux2 > 0) {
			return true;
		} else {
			return false;
		}
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

		this.nome = nome;
		this.idade = idade;
		this.celular = celular;
		this.rg = rg;
		this.cpf = cpf;
		this.facebook = facebook;
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
		} else {
			System.out.println("Nome invalido.\n");
			this.nome = "-1";
		}
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (this.validaIdade() == true) {
			this.idade = idade;
		} else {
			this.idade = -1;
		}
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		if (this.validaCelular() == true) {
			this.celular = celular;
		} else {
			this.celular = "-1";
		}
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		if (this.validaRG() == true) {
			this.rg = rg;
		} else {
			this.rg = "-1";
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (this.validaCPF() == true) {
			this.cpf = cpf;
		} else {
			this.cpf = "-1";
		}
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		if (this.validaFacebook() == true) {
			this.facebook = facebook;
		} else {
			this.facebook = "-1";
		}
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	public void validaDados()
	{
		if(this.validaNome(nome)) {
			if(this.validaCelular()) {
				if(this.validaCPF()) {
					if(this.validaIdade()) {
						if(this.validaRG()) {
							if(this.validaFacebook()) {
								System.out.println("Todos os Dados s„o V·lidos\n");
							}
							else {
								System.out.println("Facebook inv·lido");
							}
						}
						else {
							System.out.println("RG inv·lido");
						}
					}
					else {
						System.out.println("Idade inv·lida");
					}
				}
				else {
					System.out.println("CPF inv·lido");
				}
			}
			else {
				System.out.println("Celular inv·lido");
			}
		}
		else {
			System.out.println("Nome inv·lido");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result
				+ ((facebook == null) ? 0 : facebook.hashCode());
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
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
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
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
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", celular="
				+ celular + ", rg=" + rg + ", cpf=" + cpf + ", facebook="
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
