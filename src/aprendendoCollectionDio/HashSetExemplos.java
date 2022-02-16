package aprendendoCollectionDio;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExemplos {

	public static void main(String[] args) {
		
		Set<Double> notasAluno = new HashSet<>();
		
		notasAluno.add(5.8);
		notasAluno.add(9.3);
		notasAluno.add(6.5);
		notasAluno.add(6.3);
		notasAluno.add(8.5);
		notasAluno.add(9.4);
		notasAluno.add(7.2);
		notasAluno.add(5.4);
		
		System.out.println(notasAluno);
		
		notasAluno.remove(6.5); // remove a nota do set
		
		System.out.println(notasAluno);
		
		
		System.out.println("---> " + notasAluno.size());  // verifica quantidade de itens do set
		
		Iterator<Double> iterator = notasAluno.iterator();  // navega em todos os itens do iterator
		
		while(iterator.hasNext()) {
		System.out.println("++++ > " + iterator.next());
		}
		
		for(Double nota : notasAluno) {
			System.out.println("-----> " + nota);
		}
		
		//notasAluno.clear();  // exclui as notas
		
		System.out.println(notasAluno.isEmpty()); // retorna se o sete está vazio ou não
		
		}

}
