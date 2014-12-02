package Aplicativo;

import java.io.FileNotFoundException;
import java.io.IOException;
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

	public void comecarViagem() throws InterruptedException {
		int cont = 0;
		
		for (Viagem viagem : viagens) {
			CentralDeControle.separador();
			System.out.println("O condutor " + viagem.getCondutor().getNome() + " vai passar pelas seguintes localizaçoes: " + viagem.mostraLocalizacoesQueVaiPassar());
			viagem.metodoComecarViagem();
			for (Conduzido conduzido : conduzidos) { 
				for (Localizacao localizacao : viagem.getRotaFinal()) {
					cont++;
					if(conduzido.getLocalizacaoBairro().equals(localizacao) && conduzido.isEmViagem() == false) {
						if(viagem.contaValorViagem(cont) <= conduzido.getDinheiroParaCombustivel()) {
							viagem.setConduzido(conduzido);
							System.out.println("Uma viagem foi formada com o conduzido "+ conduzido.getNome() + " Ate "+ conduzido.getLocalizacaoBairro() + " com o condutor " + viagem.getCondutor().getNome());
						}
						else {
							System.out.println("\nConduzido(a) " + conduzido.getNome() + " não tem dinheiro suficiente para a viagem.");
						}
					}
				}
				cont = 0;
			}
			try{
				viagem.getConduzidos().get(0);	
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Não foi possivel gerar a viagem pois não existem conduzidos, para a localização do condutor " + viagem.getCondutor().getNome());
			}
			viagem.setDataHora(new Date());
			CentralDeControle.separador();
		}
	}
	
	//TODO remover conduzido.
	public void terminarViagem() throws InterruptedException, IOException {
		double valorPagar = 0;
		for (Viagem viagem : viagens) {
			viagem.geraLog();
			System.out.println("Começando a viagem.\n");
			for (Conduzido conduzido : viagem.getConduzidos()) {
				for(Localizacao localizacao : viagem.getRotaFinal()) {
					viagem.metodoFinalizarViagem();
					valorPagar += localizacao.getValorLocalizacao();
					if(conduzido.getLocalizacaoBairro().equals(localizacao)) {						
						conduzido.pontuarPessoa(((int) (Math.random() * 11)), viagem.getCondutor());
						System.out.println("O conduzido " + conduzido.getNome() + " pontuou o condutor " + viagem.getCondutor().getNome() + " com o status " + viagem.getCondutor().getStatus());
						viagem.getCondutor().pontuarPessoa(((int) (Math.random() * 11)), conduzido);
						System.out.println("O condutor " + viagem.getCondutor().getNome() + " pontuou o conduzido " + conduzido.getNome() + " com o status " + conduzido.getStatus());
						conduzido.sairDoCarro(valorPagar);
					}
				}
			}
			System.out.println("\nA viagem terminou o condutor chegou em sua ultima locazalicação.");
			CentralDeControle.separador();
		}
	}

	public boolean estaCadastradoCondutor(Condutor obj) {
		return condutores.contains(obj);
	}
	
	public void cadastrarCondutor(Condutor obj) {		
		if(estaCadastradoCondutor(obj) == false) {
			
			if(Pessoa.validaDados(obj) == true) {
				condutores.add(obj);
				System.out.println("condutor(a) "+obj.getNome()+" foi cadastrado(a) no sistema.\n");
			}
			
			else {
				System.out.println("Dados invalidos. \n");
			}
			
		}
		else {
			System.out.println("Condutor(a) " + obj.getNome() +"  já cadastrado(a) no sistema.\n");
		}
	
	}

	public boolean estaCadastradoConduzido(Conduzido obj) {
		return condutores.contains(obj);
	}
	
	public void cadastrarConduzido(Conduzido obj) {
		if(estaCadastradoConduzido(obj) == false) {
			
			if(Pessoa.validaDados(obj) == true) {
				conduzidos.add(obj);
				System.out.println("conduzido(a) "+obj.getNome()+" foi cadastrado(a) no sistema.\n");
			}
			
			else {
				System.out.println("Dados invalidos.\n");
			}
			
		}
		else {
			System.out.println("Conduzido(a) " + obj.getNome() +" já cadastrado(a) no sistema.\n");
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
		
	private boolean temViagem(Viagem obj) {
		return viagens.contains(obj);
	}
	
	public void cadastrarViagem(Viagem obj) {
		if(temViagem(obj) == false) {
			viagens.add(obj);
			System.out.println("Viagem com o condutor " + obj.getCondutor().getNome() + " cadastrada no sistema\n");
		}
		else {
			System.out.println("Impossivel cadastrar uma viagem existente.\n");
		}
	}
	
	public static void separador() {
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

}
