package Aplicativo;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.logging.SimpleFormatter;

import Enumeracoes.Localizacao;

public class Viagem {

	private Condutor condutor;
	private List<Conduzido> conduzidos = new ArrayList<Conduzido>();
	private List<Localizacao> rota;
	Date dataHora;

	public boolean validaCondutor(Condutor obj) {
		if (obj != null) {
			return true;
		}
		return false;
	}
	
	public void geraLog() throws FileNotFoundException {
		DateFormat dt = DateFormat.getDateInstance();
		PrintStream s = new PrintStream("viagens.log");
	
		dt.format(this.getDataHora());
		
		CentralDeControle.separador();
		s.println("Gerando uma nova viajem.\n");
		s.println("Condutor da viajem: " + this.getCondutor().getNome());
		s.println("Localizações da viajem: " + this.mostraLocalizacoesQueVaiPassar());
		s.print("Os conduzidos da viajem são: ");
		s.println("Data hora viajem: " + dt.format(this.getDataHora()) + " " + this.getDataHora().getTime());
		System.out.println(""  );
		for (Conduzido conduzido : conduzidos) {
			s.print(conduzido.getNome());
			s.print(", ");
		}
		System.out.println("Log da viajem atual foi gerado...\n");
		s.println("\n------------------------------------------------------------------------------");
	}
	
	public void metodoComecarViajem() throws InterruptedException {
		System.out.print("Iniciando a busca por caronas...");
		for(int i = 0; i < 10; i++) {
			System.out.print(".");
			Thread.sleep(500);
		}
	    System.out.print("\n");
	}
	
	public void metodoFinalizarViajem() throws InterruptedException {
		System.out.print("Viajando...");
		for(int i = 0; i < 2; i++) {
			System.out.print(".");
			Thread.sleep(500);
		}
	    System.out.print("\n");
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
		System.out.println("O conduzido(a) " + obj.getNome() + " foi removido.\n");
	}

	public Conduzido getConduzido(Conduzido obj) {
		return this.pesquisaConduzido(obj);
	}

	public List<Conduzido> getConduzidos() {
		return this.conduzidos;
	}
	
	public void setConduzido(Conduzido obj) {
		if(this.condutor.getVeiculo().validaVagas() == true) {
			if(this.validaConduzido(obj) == true) {
				conduzidos.add(obj);
				obj.setEmViagem(true);
			}
			else {
				System.out.println("Conduzido invalido.\n");
			}
		}
		else {
			System.out.println("NÃ£o hÃ¡ vagas no veiculo, favor tentar mais tarde.");
		}
	}

	public List<Localizacao> getRotaFinal() {
		return this.rota;
	}
	
	public double contaValorViagem(int cont) {
		double valorParaPagar = 0;
		
		for(int i = 0; i < cont; i++) {
			valorParaPagar = valorParaPagar + this.getRotaFinal().get(i).getValorLocalizacao();
		}
		
		return valorParaPagar;
	}
	
	public String mostraLocalizacoesQueVaiPassar() {
		String localizacao = ""; 
		
		for (Localizacao elemento : this.getRotaFinal()) {
			localizacao = localizacao + elemento;
			localizacao = localizacao + " ";
 		}
		
		return localizacao;
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
	
	public void mostrarPessoasEmViajem() {
		System.out.print("Os conduzidos(as): ");
		for (Conduzido conduzido : conduzidos) {
			System.out.print(conduzido.getNome() + ", ");
		}
		System.out.print("estão em viajem com o condutor " + this.getCondutor().getNome() + "\n\n");
	}
	
	public Viagem(Condutor condutor) {
		if(validaCondutor(condutor) == true) {
			this.condutor = condutor;
			this.rota = condutor.getLocalizacoes();
		}
		else {
			System.out.println("Impossivel criar a viajem condutor invalido.\n");
		}
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
		return true;
	}	
	
}
