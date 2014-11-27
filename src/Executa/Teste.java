package Executa;

import Aplicativo.*;
import Banco.*;
import Enumeracoes.*;

import java.util.ArrayList;

public class Teste {

	public static void main(String[] args) {
		Conduzido Conduzido1 = new Conduzido(Dados.dinheiroCombustivel[4], Dados.nomes[0],Dados.idade[0],Dados.celular[0],Dados.rg[0], Dados.cpf[0],Dados.facebook[0], Dados.LOCALIZACAO_UM.get(0));
		Conduzido Conduzido2 = new Conduzido(Dados.dinheiroCombustivel[3], Dados.nomes[1],Dados.idade[1],Dados.celular[1],Dados.rg[1], Dados.cpf[1],Dados.facebook[1], Dados.LOCALIZACAO_UM.get(1));
		Conduzido Conduzido3 = new Conduzido(Dados.dinheiroCombustivel[5], Dados.nomes[2],Dados.idade[2],Dados.celular[2],Dados.rg[2], Dados.cpf[2],Dados.facebook[2], Dados.LOCALIZACAO_UM.get(2));
		
		System.out.println(Conduzido1.toString());
		
		Condutor Condutor1 = new Condutor(Dados.CNH[0], new Veiculo(Dados.Placa[0], CorDoCarro.PRETO, Dados.NumeroDeVagas[3]), Dados.nomes[0], Dados.idade[0], Dados.celular[0], Dados.rg[0], Dados.cpf[0], Dados.facebook[0], Dados.LOCALIZACAO_DOIS);
		Condutor Condutor2 = new Condutor(Dados.CNH[1], new Veiculo(Dados.Placa[1], CorDoCarro.PRETO, Dados.NumeroDeVagas[2]), Dados.nomes[1], Dados.idade[1], Dados.celular[1], Dados.rg[1], Dados.cpf[1], Dados.facebook[1], Dados.LOCALIZACAO_TREIS);
		Condutor Condutor3 = new Condutor(Dados.CNH[2], new Veiculo(Dados.Placa[2], CorDoCarro.PRETO, Dados.NumeroDeVagas[4]), Dados.nomes[2], Dados.idade[2], Dados.celular[2], Dados.rg[2], Dados.cpf[2], Dados.facebook[2]);
		Condutor3.setLocalizacoes(Dados.LOCALIZACAO_UM);
		
		Viagem primeiraViagem = new Viagem(Condutor1);
		
		primeiraViagem.setConduzido(Conduzido1);
		primeiraViagem.setConduzido(Conduzido2);
		primeiraViagem.setConduzido(Conduzido3);
		
		
		
		
		
	}

}
