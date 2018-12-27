package genetico_TuanyMariah;

import java.util.ArrayList;
import java.util.Collections;

public class Populacao {

	private ArrayList<Individuo> individuos;

	public Populacao() {
		individuos = new ArrayList<>();
	}

	public void iniciarPopulacao(int tamPop) {
		for (int i = 0; i < tamPop; i++) {
			individuos.add(new Individuo());
		}
		ordenarPopulacao();
		for (Individuo i : individuos) {
			System.out.println("aptidao: " + i.getAptidao() + " | Natacao: " + i.getNatacao() + " | Ciclismo: " + i.getCiclismo());
		}
	}

	public void ordenarPopulacao() {
		Collections.sort(individuos, Collections.reverseOrder());

	}

	public Individuo getIndividuo(int pos) {
		return individuos.get(pos);
	}

	public void setIndividuo(Individuo individuo) {//recebe o individuo como paramentro 
		individuos.add(individuo);
	}

	public int getNumIndividuos() {
		return individuos.size();

	}

	public ArrayList<Individuo> getIndividuos() {
		return individuos;
	}

	public void setIndividuos(ArrayList<Individuo> individuos) {
		this.individuos.addAll(individuos);//coloca a lista de filhos depois do cruzamento
	}

	/*
	  public static void main(String[] args) { 
		  Populacao p = new Populacao();
		  p.iniciarPopulacao(10); 
		  for (Individuo i : p.getIndividuos()) {
			  System.out.println("aptidao: "+i.getAptidao());
			  } 
		  }
	 
*/
}
