package aprendendoCollectionDio;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExemplo {

	public static void main(String[] args) {
		
		LinkedHashSet<Integer> sequenciaNumerica = new LinkedHashSet<>();
		// adiciona numeros no set
		sequenciaNumerica.add(1);
		sequenciaNumerica.add(2);
		sequenciaNumerica.add(4);
		sequenciaNumerica.add(8);
		sequenciaNumerica.add(16);
		
		System.out.println("++++ > " + sequenciaNumerica);
		
		sequenciaNumerica.remove(4);  // remove um numero no set
		
		System.out.println("-----> " + sequenciaNumerica);
		
		System.out.println(sequenciaNumerica.size());  // lista tamanho do set
		
		Iterator<Integer> iterator = sequenciaNumerica.iterator();  // navega em todos itens do set
		while(iterator.hasNext()) {
			System.out.println("++++ > " + iterator.next());
		}
		
		for(Integer numero : sequenciaNumerica) {
			System.out.println("---> " + numero);
		}
		
		//sequenciaNumerica.clear();   //limpa o set dos dados
		
		System.out.println(sequenciaNumerica.isEmpty());  // verifica se set está vazio

	}

}
