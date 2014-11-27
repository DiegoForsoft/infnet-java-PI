package Executa;

import Aplicativo.*;
import Banco.*;
import Enumeracoes.*;
import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		Conduzido Conduzido1 = new Conduzido(Dados.nomes[0],Dados.idade[0],Dados.celular[0],Dados.rg[0], Dados.cpf[0],Dados.facebook[0], Dados.LOCALIZACAO_UM.get(0));
		Conduzido Conduzido2 = new Conduzido(Dados.nomes[1],Dados.idade[1],Dados.celular[1],Dados.rg[1], Dados.cpf[1],Dados.facebook[1], Dados.LOCALIZACAO_UM.get(1));
		Conduzido Conduzido3 = new Conduzido(Dados.nomes[2],Dados.idade[2],Dados.celular[2],Dados.rg[2], Dados.cpf[2],Dados.facebook[2], Dados.LOCALIZACAO_UM.get(2));
		ArrayList<Localizacao> localizacao = new ArrayList<Localizacao>();
		localizacao.addAll(Dados.LOCALIZACAO_UM);
		Condutor Condutor1 = new Condutor(Dados.nomes[0], Dados.idade[0], Dados.celular[0], Dados.rg[0], Dados.cpf[0], Dados.facebook[0]);
		Condutor Condutor2 = new Condutor(Dados.nomes[1], Dados.idade[1], Dados.celular[1], Dados.rg[1], Dados.cpf[1], Dados.facebook[1]);
		Condutor Condutor3 = new Condutor(Dados.nomes[2], Dados.idade[2], Dados.celular[2], Dados.rg[2], Dados.cpf[2], Dados.facebook[2]);
		Viagem primeiraViagem = new Viagem(Condutor1, localizacao);
		//Tem que ser implementado um banco de dados para informações do veículo e instancialo para poder jogar esse veiculo no condutor
		primeiraViagem.setConduzido(Conduzido1);
		primeiraViagem.setConduzido(Conduzido2);
		primeiraViagem.setConduzido(Conduzido3);
		primeiraViagem.calculaValorViagem(localizacao);
		
		
		
	}

}
