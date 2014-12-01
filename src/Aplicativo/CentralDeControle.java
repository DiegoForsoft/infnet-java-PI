package Aplicativo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Enumeracoes.Localizacao;

public class CentralDeControle {
	
	private Set<Condutor> condutores = new HashSet<Condutor>();
	private Set<Conduzido> conduzidos = new HashSet<Conduzido>();
	private List<Viagem> viagens = new ArrayList<Viagem>();
	
//	public void notificiarLocalizacaoCompativel() {
//		for (Condutor condutor : condutores) {
//			Viagem v1 = new Viagem();
//			v1.setDataHora(new Date());
//			for (Conduzido conduzido : conduzidos) {
//				if(condutor.getLocalizacaoBairro().equals(conduzido.getLocalizacaoBairro())) {
//					v1.setCondutor(condutor);
//					v1.setConduzido(conduzido);
//					//v1.setRotaFinal(condutor.getLocalizacaoBairro());
//					//v1.setValorDaViagem(condutor.getLocalizacaoBairro().getValorViagem());
//				}
//			}
//			if(v1.getCondutor() == null || v1.getConduzidos() == null || v1.getRotaFinal() == null) {
//				System.out.println("N√£o existe localiza√ß√£o para o "+condutor.getNome());
//			}
//			else {
//				this.cadastrarViagem(v1);
//				System.out.println("Uma viagem foi formada com o "+v1.getCondutor().getNome()+" e o(s) "+v1.getConduzidos());
//			}
//		}
//	}
	
	public void comecarViagem() throws InterruptedException {
		int cont = 0;
		
		for (Viagem viagem : viagens) {
			CentralDeControle.separador();
			System.out.println("O condutor " + viagem.getCondutor().getNome() + " vai passar pelas seguintes localizaÁoes: " + viagem.mostraLocalizacoesQueVaiPassar());
			viagem.metodoComecarViajem();
			for (Conduzido conduzido : conduzidos) { 
				for (Localizacao localizacao : viagem.getRotaFinal()) {
					cont++;
					if(conduzido.getLocalizacaoBairro().equals(localizacao) && conduzido.isEmViagem() == false) {
						if(viagem.contaValorViagem(cont) <= conduzido.getDinheiroParaCombustivel()) {
							viagem.setConduzido(conduzido);
							System.out.println("Uma viagem foi formada com o conduzido "+ conduzido.getNome() + " Ate "+ conduzido.getLocalizacaoBairro() + " com o condutor " + viagem.getCondutor().getNome());
						}
						else {
							System.out.println("\nConduzido " + conduzido.getNome() + " n„o tem dinheiro suficiente para a viagem.");
						}
					}
				}
				cont = 0;
			}
			viagem.setDataHora(new Date());
			CentralDeControle.separador();
		}
	}
	//TODO remover conduzido.
	public void terminarViagem() throws InterruptedException {
		double valorPagar = 0;
		for (Viagem viagem : viagens) {
			CentralDeControle.separador();
			for (Conduzido conduzido : viagem.getConduzidos()) {
				for(Localizacao localizacao : viagem.getRotaFinal()) {
					viagem.metodoFinalizarViajem();
					valorPagar += localizacao.getValorLocalizacao();
					if(conduzido.getLocalizacaoBairro().equals(localizacao)) {						
						conduzido.pontuarPessoa(((int) (Math.random() * 11)), viagem.getCondutor());
						viagem.getCondutor().pontuarPessoa(((int) (Math.random() * 11)), conduzido);
						conduzido.sairDoCarro(valorPagar);
					}
				}
			}
			CentralDeControle.separador();
		}
	}

	public boolean estaCadastradoCondutor(Condutor obj) {
		return condutores.contains(obj);
	}
	
	public void cadastrarCondutor(Condutor obj) {		
		if(estaCadastradoCondutor(obj) == false) {
			condutores.add(obj);
			System.out.println("Condutor(a) "+obj.getNome()+" foi cadastrado(a) no sistema.\n");
		}
		else {
			System.out.println("Pessoa j· cadastrada no sistema.\n");
		}
	
	}

	public boolean estaCadastradoConduzido(Conduzido obj) {
		return condutores.contains(obj);
	}
	
	public void cadastrarConduzido(Conduzido obj) {
		if(estaCadastradoConduzido(obj) == false) {
			conduzidos.add(obj);
			System.out.println("Conduzido(a) "+obj.getNome()+" foi cadastrado(a) no sistema.\n");
		}
		else {
			System.out.println("Pessoa j· cadastada no sistema.\n");
		}
	}

	public void removerCondutor(Condutor obj) {
		if(estaCadastradoCondutor(obj) == true) {
			condutores.remove(obj);
			System.out.println("O condutor "+obj.getNome()+" foi removido do sistema.\n");
		}
		else {
			System.out.println("Impossivel remover um condutor n√£o cadastrado no nosso sistema.\n");
		}
	}

	public void removerConduzido(Conduzido obj) {
		if(estaCadastradoConduzido(obj) == true) {
			conduzidos.remove(obj);
			System.out.println("O "+obj.getNome()+" Foi removido do sistema.\n");
		}
		else {
			System.out.println("Impossivel remover um conduzido n√£o cadastrado no nosso sistema.\n");
		}
	}
	
	//Aqui eu n√£o criei um m√©todo para verificar se a viagem j√° existe pois ela pode estar sendo repetida.
	
	private boolean temViajem(Viagem obj) {
		return viagens.contains(obj);
	}
	
	public void cadastrarViagem(Viagem obj) {
		if(temViajem(obj) == false) {
			viagens.add(obj);
			System.out.println("Viagem cadastrada no sistema\n");
		}
		else {
			System.out.println("Impossivel cadastrar uma viagem existente.\n");
		}
	}
	
	public static void separador()//Separa as informaÁıes para uma melhor visualizaÁ„o
	{
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	public Set<Condutor> getCondutores() {
		return condutores;
	}

	public Set<Conduzido> getConduzidos() {
		return conduzidos;
	}

	public List<Viagem> getViagens() {
		return viagens;
	}

	//Esses 3 n√£o estamos usando, podem ser usados na constru√ß√£o de um .log.
	public Viagem pesquisarViagem(Viagem obj) {
		return viagens.get(viagens.indexOf(obj));
	}

//	public Condutor pesquisarCondutor(Condutor obj) {
//		return condutores.get(condutores.indexOf(obj));
//	}
//
//	public Conduzido pesquisarConduzido(Conduzido obj) {
//		return conduzidos.get(conduzidos.indexOf(obj));
//	}

}
