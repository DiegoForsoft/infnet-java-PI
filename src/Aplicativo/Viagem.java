package Aplicativo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enumeracoes.Localizacao;

public class Viagem {

	private Condutor condutor;
	private List<Conduzido> conduzidos = new ArrayList<Conduzido>();
	private List<Localizacao> rota;
	Date dataHora;
	private double valorDaViagem;

	public boolean validaCondutor(Condutor obj) {
		if (obj != null) {
			return true;
		}
		return false;
	}

	public boolean validaConduzido(Conduzido obj) {
		if (obj != null) {
			return true;
		}
		return false;
	}
	
	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		if (this.validaCondutor(condutor) == true) {
			this.condutor = condutor;
		}
		System.out.println("Condutor invalido.\n");
	}

	private Conduzido pesquisaConduzido(Conduzido obj) {
		Conduzido conduzidoAchado = null;
		for (Conduzido element : conduzidos) {
			if (element.equals(obj) == true) {
				conduzidoAchado = element;
			}
		}
		return conduzidoAchado;
	}
	
	public void removeConduzido(Conduzido obj) {
		this.conduzidos.remove(obj);
		System.out.println("O conduzido " + obj.getNome() + "foi removido.\n");
	}

	public Conduzido getConduzido(Conduzido obj) {
		return this.pesquisaConduzido(obj);
	}

	public List<Conduzido> getConduzidos() {
		return this.conduzidos;
	}
	
	public void setConduzido(Conduzido obj) {
		if(this.condutor.getVeiculo().validaVagas() == true) {
			conduzidos.add(obj);
			obj.setEmViagem(true);
		}
		else {
			System.out.println("N√£o h√° vagas no veiculo, favor tentar mais tarde.");
		}
	}

	public double getValorDaViagem() {
		return valorDaViagem;
	}

	public void setValorDaViagem(double valorDaViagem) {
		this.valorDaViagem = valorDaViagem;
	}

	public List<Localizacao> getRotaFinal() {
		return this.rota;
	}

	public void setRotaFinal(List<Localizacao> obj) {
		this.rota = obj;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHoraRecebida) {
		this.dataHora = dataHoraRecebida;
	}

	public int getNumViajantes() {
		return this.conduzidos.size();
	}

	private boolean validaValorViagem(double valorDaViagem) {
		if (valorDaViagem >= 0) {
			this.valorDaViagem = valorDaViagem;
			return true;
		} else {
			System.out
					.println("N√£o √© possivel o valor da viagem ser menor que zero.\n");
			return false;
		}
	}
	
	/*
	public void calculaValorViagem(ArrayList <Localizacao> localizacao)
	{
		valorDaViagem = localizacao.get(0).getValorViagem() + localizacao.get(1).getValorViagem() + localizacao.get(2).getValorViagem() + localizacao.get(3).getValorViagem();
	}*/

	// acho que n„o È necess·rio
	public Viagem(Condutor condutor, List<Localizacao> rotaFinal, double valorDaViagem) {
		this.condutor = condutor;
		this.rota = condutor.getLocalizacoes();
		this.valorDaViagem = valorDaViagem;
	}
	public Viagem(Condutor condutor) {
		this.condutor = condutor;
		this.rota = condutor.getLocalizacoes();
	}

	public Viagem() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((condutor == null) ? 0 : condutor.hashCode());
		result = prime * result
				+ ((conduzidos == null) ? 0 : conduzidos.hashCode());
		result = prime * result
				+ ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((rota == null) ? 0 : rota.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorDaViagem);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Viagem other = (Viagem) obj;
		if (condutor == null) {
			if (other.condutor != null) {
				return false;
			}
		} else if (!condutor.equals(other.condutor)) {
			return false;
		}
		if (conduzidos == null) {
			if (other.conduzidos != null) {
				return false;
			}
		} else if (!conduzidos.equals(other.conduzidos)) {
			return false;
		}
		if (dataHora == null) {
			if (other.dataHora != null) {
				return false;
			}
		} else if (!dataHora.equals(other.dataHora)) {
			return false;
		}
		if (rota == null) {
			if (other.rota != null) {
				return false;
			}
		} else if (!rota.equals(other.rota)) {
			return false;
		}
		if (Double.doubleToLongBits(valorDaViagem) != Double
				.doubleToLongBits(other.valorDaViagem)) {
			return false;
		}
		return true;
	}
	
	
}
