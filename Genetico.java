package genetico_TuanyMariah;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Genetico {
	private Random rand= new Random();
	private Populacao populacao = new Populacao();
	
	private double taxaCruzamento = 0.9;
	private boolean elitismo = true;
	private int maximoGeracoes = 50;
	private int tamanhoPopulacao = 10;
	
	private static double taxaDeMutacao = 0.5;
	
	
	public void Principal() {
		
		int geracao=0 ;
		populacao.iniciarPopulacao(tamanhoPopulacao);//primeira geracao (aleatoria)
		do {
			
			populacao = gerarPopulacao();
			geracao++;
			System.out.println("\nGeração " + geracao + " | " + populacao.getIndividuo(0) + " (Aptidao: " + populacao.getIndividuo(0).getAptidao() + ")\n");
		}while(geracao < maximoGeracoes);
		//System.out.println("\nGeração " + geracao + " | " + populacao.getIndividuo(0) + " (Aptidao: " + populacao.getIndividuo(0).getAptidao() + ")\n");
		JOptionPane.showMessageDialog(null," Geração " + geracao + " | " + populacao.getIndividuo(0) + " (Aptidao: " + populacao.getIndividuo(0).getAptidao() + ")");

	}

	public Populacao gerarPopulacao() {
		Populacao populacaoTemporaria = new Populacao();
		/*a cada volta pega o individuo mais apto antes de selecionar e cruzar*/
		if(elitismo) {
			populacao.ordenarPopulacao();
			populacaoTemporaria.setIndividuo(populacao.getIndividuo(0));
			//System.out.println(populacao.getIndividuo(0));
		}
		while(populacaoTemporaria.getNumIndividuos()< tamanhoPopulacao) {
			populacaoTemporaria.setIndividuos(cruzamento(selecao()));			
		}
		populacaoTemporaria.ordenarPopulacao();
		return populacaoTemporaria;
		
	}
	
	public ArrayList<Individuo> selecao() {
		ArrayList<Individuo> pais = new ArrayList<>();
		
		
		//seleciona 2 individuos de forma aleatoria usando torneio binario... esses dois individuos selecionados seram os pais
		for(int i = 0; i < 2; i++) {
			Individuo i1 = populacao.getIndividuo(rand.nextInt(tamanhoPopulacao));
			Individuo i2 = populacao.getIndividuo(rand.nextInt(tamanhoPopulacao));
			if(i1.getAptidao() > i2.getAptidao()) {//aqui eu vejo quem tem eh o melhor, quem tem a aptidao maior
				pais.add(i1);
			}else {
				pais.add(i2);
			}
		}
		return pais;
	}
	
	public ArrayList<Individuo> cruzamento(ArrayList<Individuo> pais) {
		double aux;
		ArrayList<Individuo> filhos = new ArrayList<>();
		
		filhos.add(new Individuo(pais.get(0).getGenes())); // criação dos filhos iguais ao pai 0
		filhos.add(new Individuo(pais.get(1).getGenes())); // criação dos filhos iguais ao pai 1
		if(rand.nextDouble() <= taxaCruzamento) {
			
			aux = filhos.get(0).getNatacao();
			filhos.get(0).setNatacao(filhos.get(1).getNatacao());
			filhos.get(1).setNatacao(aux);
		}
		return filhos;
	}
	
	public double getTaxaCruzamento() {
		return taxaCruzamento;
	}
	public void setTaxaCruzamento(double taxaCruzamento) {
		this.taxaCruzamento = taxaCruzamento;
	}
	public static double getTaxaDeMutacao() {
		return taxaDeMutacao;
	}
	public static void setTaxaDeMutacao(double taxaDeMutacao) {
		Genetico.taxaDeMutacao = taxaDeMutacao;
	}
	public boolean isElitismo() {
		return elitismo;
	}
	public void setElitismo(boolean elitismo) {
		this.elitismo = elitismo;
	}
	public int getMaximoGeracoes() {
		return maximoGeracoes;
	}
	public void setMaximoGeracoes(int maximoGeracoes) {
		this.maximoGeracoes = maximoGeracoes;
	}
	
	public int getTamanhoPopulacao() {
		return tamanhoPopulacao;
	}

	public void setTamanhoPopulacao(int tamanhoPopulacao) {
		this.tamanhoPopulacao = tamanhoPopulacao;
	}

	public Populacao getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Populacao populacao) {
		this.populacao = populacao;
	}
	
}
