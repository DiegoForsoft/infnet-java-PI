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
//				System.out.println("Não existe localização para o "+condutor.getNome());
//			}
//			else {
//				this.cadastrarViagem(v1);
//				System.out.println("Uma viagem foi formada com o "+v1.getCondutor().getNome()+" e o(s) "+v1.getConduzidos());
//			}
//		}
//	}
	
	public void comecarViagem() {
		for (Viagem viagem : viagens) { 
			System.out.println("Iniciando a busca por caronas...\n");
			for (Conduzido conduzido : conduzidos) { 
				for (Localizacao localizacao : viagem.getRotaFinal()) {
					System.out.println("Passando pela local " + localizacao);
					if(conduzido.getLocalizacaoBairro().equals(localizacao) && conduzido.isEmViagem() == false) {
						viagem.setConduzido(conduzido);
						System.out.println("Uma viagem foi formada com o conduzido "+ conduzido.getNome() + " Ate "+ conduzido.getLocalizacaoBairro() + "com o condutor " + viagem.getCondutor().getNome());
					}
				}
			}
			viagem.setDataHora(new Date());
		}
	}
	
	public void terminarViagem() {
		double valorPagar = 0;
		for (Viagem viagem : viagens) {
			for (Conduzido conduzido : viagem.getConduzidos()) {
				for(Localizacao localizacao : viagem.getRotaFinal()) {
					valorPagar += localizacao.getValorViagem();
					if(conduzido.getLocalizacaoBairro().equals(localizacao)) {						
						conduzido.pontuarPessoa(((int)Math.random() * 11), viagem.getCondutor());
						viagem.getCondutor().pontuarPessoa(((int)Math.random() * 11), conduzido);
						conduzido.sairDoCarro(valorPagar);
						viagem.removeConduzido(conduzido);
					}
				}
			}
		}
	}

	public boolean estaCadastradoCondutor(Condutor obj) {
		return condutores.contains(obj);
	}
	//TODO botar para cadastrar só quando a validação for true.
	private boolean validaPessoa(Condutor obj) {
		return (obj.toString().matches("\\D+"));
	}
	
	public void cadastrarCondutor(Condutor obj) {		
		if(estaCadastradoCondutor(obj) == false) {
			condutores.add(obj);
			System.out.println("Condutor(a) "+obj.getNome()+" foi cadastrado(a) no sistema.\n");
		}
		else {
			System.out.println("Pessoa j� cadastrada no sistema.\n");
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
			System.out.println("Pessoa j� cadastada no sistema.\n");
		}
	}

	public void removerCondutor(Condutor obj) {
		if(estaCadastradoCondutor(obj) == true) {
			condutores.remove(obj);
			System.out.println("O condutor "+obj.getNome()+" foi removido do sistema.\n");
		}
		else {
			System.out.println("Impossivel remover um condutor não cadastrado no nosso sistema.\n");
		}
	}

	public void removerConduzido(Conduzido obj) {
		if(estaCadastradoConduzido(obj) == true) {
			conduzidos.remove(obj);
			System.out.println("O "+obj.getNome()+" Foi removido do sistema.\n");
		}
		else {
			System.out.println("Impossivel remover um conduzido não cadastrado no nosso sistema.\n");
		}
	}
	
	//Aqui eu não criei um método para verificar se a viagem já existe pois ela pode estar sendo repetida.
	
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
	
	public void separador()//Separa as informa��es para uma melhor visualiza��o
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

	//Esses 3 não estamos usando, podem ser usados na construção de um .log.
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
