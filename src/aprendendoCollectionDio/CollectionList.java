package aprendendoCollectionDio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionList {

	public static void main(String[] args) {
		
		List<String> nomes = new ArrayList<>();
		nomes.add("Marcelo");
		nomes.add("Jose");
		nomes.add("Walter");
		nomes.add("Carlos");
		nomes.add("Luiz");
		nomes.add("Antonio");
		nomes.add("Pedro");
		
		System.out.println("Liste todos da lista : " + nomes);
		
		nomes.set(3,"Margarida");
		
		System.out.println("Mude o nome da posição 3 para Margarida : " + nomes);
		
		Collections.sort(nomes);
		
		nomes.set(5, "Waldemar");
		
		System.out.println("Troque o nome na posição 5 para Waldemar : " + nomes);
		
		nomes.remove(2);
		
		System.out.println("Remove da lista o numero 2 : " + nomes);
		
		nomes.remove("Walter");
		
		System.out.println("Remova o nome Walter da lista : " + nomes);
		
		String nome = nomes.get(1);
		
		System.out.println("Busque o nome na posição 1 : " + nome);
		
		int tamanho = nomes.size();
		
		System.out.println("Qual tamanho da lista : " + tamanho);
		
		boolean temMarcelo = nomes.contains("Marcelo");
		
		System.out.println("Tem o nome Marcelo : " + temMarcelo);
		
		boolean listaEstaVazia = nomes.isEmpty();   // retorna se lista está vazia
		
		System.out.println("Lista está vazia : " + listaEstaVazia);
		
		int posicao = nomes.indexOf("Jose");
		
		System.out.println("A posição do walter na lista é : " + posicao);
		
		//nomes.clear();      // retira todos os nomes da lista
		
		for(String nomeDoItem : nomes) {
			System.out.println(" ++++ >> " + nomeDoItem);
		}
		
		Iterator<String> iterator = nomes.iterator();
		while(iterator.hasNext()) {
			System.out.println("---->" + iterator.next());
		}
	}

}
