package Executa;

import java.io.FileNotFoundException;
import java.io.IOException;

import Aplicativo.*;
import Banco.*;
import Enumeracoes.*;

public class Teste {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Aplicativo Carona Coletiva: \n");
		
		CentralDeControle CDC = new CentralDeControle();
		
		Conduzido Conduzido1 = new Conduzido(Dados.dinheiroCombustivel[4], Dados.nomes[0],Dados.idade[0],Dados.celular[0],Dados.rg[0], Dados.cpf[0],Dados.facebook[0], Dados.LOCALIZACAO_UM.get(0));
		Conduzido Conduzido2 = new Conduzido(Dados.dinheiroCombustivel[7], Dados.nomes[1],Dados.idade[1],Dados.celular[1],Dados.rg[1], Dados.cpf[1],Dados.facebook[1], Dados.LOCALIZACAO_UM.get(1));
		Conduzido Conduzido3 = new Conduzido(Dados.dinheiroCombustivel[8], Dados.nomes[2],Dados.idade[2],Dados.celular[2],Dados.rg[2], Dados.cpf[2],Dados.facebook[2], Dados.LOCALIZACAO_UM.get(2));
		
		Conduzido1.mostraConduzidos();
		CentralDeControle.separador();
		Conduzido2.mostraConduzidos();
		CentralDeControle.separador();
		Conduzido3.mostraConduzidos();
		CentralDeControle.separador();
		
		Condutor Condutor1 = new Condutor(Dados.CNH[0], new Veiculo(Dados.Placa[3], CorDoCarro.BRANCO, Dados.NumeroDeVagas[3]), Dados.nomes[3], Dados.idade[3], Dados.celular[3], Dados.rg[3], Dados.cpf[3], Dados.facebook[3], Dados.LOCALIZACAO_DOIS);
		Condutor Condutor2 = new Condutor(Dados.CNH[4], new Veiculo(Dados.Placa[4], CorDoCarro.VERMELHO, Dados.NumeroDeVagas[2]), Dados.nomes[4], Dados.idade[4], Dados.celular[4], Dados.rg[4], Dados.cpf[4], Dados.facebook[4], Dados.LOCALIZACAO_TREIS);
		Condutor Condutor3 = new Condutor(Dados.CNH[2], new Veiculo(Dados.Placa[2], CorDoCarro.PRETO, Dados.NumeroDeVagas[4]), Dados.nomes[5], Dados.idade[5], Dados.celular[5], Dados.rg[5], Dados.cpf[5], Dados.facebook[5]);
		Condutor3.setLocalizacoes(Dados.LOCALIZACAO_UM);
		
		Condutor1.mostraCondutor();
		CentralDeControle.separador();
		Condutor2.mostraCondutor();
		CentralDeControle.separador();
		Condutor3.mostraCondutor();
		CentralDeControle.separador();
		
		Viagem primeiraViagem = new Viagem(Condutor1);
		Viagem segundaViagem = new Viagem(Condutor2);
		
		CDC.cadastrarViagem(primeiraViagem);
		CDC.cadastrarViagem(segundaViagem);
		
		CDC.cadastrarCondutor(Condutor1);
		CDC.cadastrarCondutor(Condutor2);
		CDC.cadastrarCondutor(Condutor3);
		
		CDC.cadastrarConduzido(Conduzido1);
		CDC.cadastrarConduzido(Conduzido2);
		CDC.cadastrarConduzido(Conduzido3);
				
		CDC.comecarViagem();
		
		primeiraViagem.mostrarPessoasEmViagem();
		
		CDC.terminarViagem();
		
	}

}
