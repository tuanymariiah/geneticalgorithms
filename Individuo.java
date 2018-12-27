package genetico_TuanyMariah;

import java.util.Random;

public class Individuo implements Comparable<Individuo> {
	private Random random = new Random();
	private Double aptidao;

	private double natacao; // x1
	private double ciclismo; // x2

	public Individuo() {
		do {
			this.setCiclismo();
			this.setNatacao();
		} while (!validar());
		avaliar();
	}

	public Individuo(double[] genes) {
		natacao = genes[0];
		ciclismo = genes[1];
		/*
		 * caso o random atinja a taxa de mutacao ocorre a definicao do gene q sera
		 * mutado passando como parametro no metodo de mutacao
		 */
		if (random.nextDouble() <= Genetico.getTaxaDeMutacao()) {
			int posicaoRandom = random.nextInt(genes.length);
			mutacao(posicaoRandom);
		}
		avaliar();
	}

	public boolean validar() {
		double recursosFinanceiros = 0, energia = 0, tempo = 0;
		recursosFinanceiros = 3 * natacao + 2 * ciclismo;
		energia = 1500 * natacao + 1000 * ciclismo;
		tempo = 2 * natacao + 2 * ciclismo;
		if (recursosFinanceiros <= 70 && energia <= 80000 && tempo <= 18) {
			return true;
		} else {
			return false;
		}
	}

	public void mutacao(int posicao) {
		do {
			if (posicao == 0) {
				this.setNatacao();
			} else if (posicao == 1) {

				this.setCiclismo();
			}
		} while (!validar());
	}

	public void avaliar() {
		aptidao = natacao + ciclismo;
	}

	public Double getAptidao() {
		return aptidao;
	}

	public void setAptidao(Double aptidao) {
		this.aptidao = aptidao;
	}

	public double getNatacao() {
		return natacao;
	}

	public void setNatacao(double natacao) {
		this.natacao = natacao;
	}

	public double getCiclismo() {
		return ciclismo;
	}

	public void setCiclismo(double ciclismo) {
		this.ciclismo = ciclismo;
	}

	public void setCiclismo() {
		this.ciclismo = random.nextDouble() * 100;
	}

	public void setNatacao() {
		this.natacao = random.nextDouble() * 100;
	}

	/*
	 * eh criado e retornado um vetor em tempo de execucao que contem os valores de
	 * natacao e ciclismo
	 */
	public double[] getGenes() {
		return new double[] { natacao, ciclismo };
	}

	
	@Override
	public int compareTo(Individuo i) {
		return this.aptidao.compareTo(i.aptidao);
	}

	@Override
	public String toString() {
		return "Melhor Individuo: "+ "natacao: " + natacao + " ciclismo: " + ciclismo + "]";
	}
}
