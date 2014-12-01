package Banco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Enumeracoes.Localizacao;

public class Dados 
{	//Banco de dados de Pessoa
	public static final String[] nomes = {"Diego", "Victor", "Fernanda", "Milton", "Leonardo", "Felipe"};
	public static final int[] idade =  {21,24,20,21,18,27};
	public static final String[] celular = {"(21)98785-8874", "(21)97841-8025", "(21)92544-7895", "(21)96547-7854", "(21)92365-4789", "(21)91234-7852"};
	public static final String[] rg = {"87.458.879-5", "04.145.784-8", "20.587.741-2", "87.458.879-5", "25.423.688-1", "79.658.798-7"};
	public static final String[] cpf = {"148.857.998-21", "287.472.778-11", "349.961.176-87", "157.678.458-96", "426.665.122-72", "489.268.715-53"};
	public static final String[] facebook = {"diego.alves@facebook.com", "victor.lopes@facebook.com", "milton.pereira@facebook.com", "leonardo.villela@facebook.com", "fernanda.almeida@facebook.com", "felipe.aguiar@facebook.com"};
	
	//Banco de dados do Conduzido
	public static final double[] dinheiroCombustivel = {5,10,20,25,50,100,150,200,20000};
	
	//Banco de dados do Condutor
	public static final String[] CNH = {"65271774050", "97221874150", "78971715757", "19254127891", "67045988812", "91212455578"};

	//Banco de dados Localização 
	public static final List<Localizacao> LOCALIZACAO_UM = new ArrayList<Localizacao>(Arrays.asList(new Localizacao[]{Localizacao.CENTRO, Localizacao.CASADOLP, 
	Localizacao.LEBLON, Localizacao.LEME}));
	
	public static final List<Localizacao> LOCALIZACAO_DOIS = new ArrayList<Localizacao>(Arrays.asList(new Localizacao[]{Localizacao.MEIER, Localizacao.CASADOLP, 
	Localizacao.LEBLON, Localizacao.ROCINHA}));
	
	public static final List<Localizacao> LOCALIZACAO_TREIS = new ArrayList<Localizacao>(Arrays.asList(new Localizacao[]{Localizacao.LINS, Localizacao.LEBLON, 
	Localizacao.ROCINHA, Localizacao.LEME}));
	
	//Banco de dados do veículo
	public static final String[] Placa = {"JMH-1245","GHJ-4579", "UTX-4397", "ALM-7712", "RMN-4838"};
	
	public static final int[] NumeroDeVagas = {1,2,3,4,5};
			
}