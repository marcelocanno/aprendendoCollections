package aprendendoCollections;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
	 
		List<String> nomes = new ArrayList<>();
		List<String> nomes2 = new ArrayList<>();
		nomes.add("Marcelo");
		nomes.add("DevDojo");
		nomes2.add("Julio");
		nomes2.add("DevDojo2");
		System.out.println("size : " + nomes.size());
		System.out.println(nomes.remove("DevDojo"));
		System.out.println("size : " + nomes.size());
		//nomes.clear();   // limpa todos os nomes da list
		nomes.addAll(nomes2);
		int size = nomes.size();
		for(int i = 0; i<size; i++) {
			System.out.println(nomes.get(i));
		}
		List<Integer> numeros = new ArrayList<>();
		numeros.add(10);
		numeros.add(50);
		numeros.add(102);
		for(Integer num : numeros) {
			System.out.println(num);
		}
	}

}
