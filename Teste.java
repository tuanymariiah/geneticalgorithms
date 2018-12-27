package genetico_TuanyMariah;

import java.util.ArrayList;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lista = new ArrayList<String>();
        for (int i = 1; i <= 10; ++i) {
            lista.add ("String " + i);
        }
        // 0 == from - inclusive
        // 5 == to - exclusive
        List<String> aux = lista.subList (0, 7);
        for (String s : aux) {
            System.out.println (s);
        }
	}

}
