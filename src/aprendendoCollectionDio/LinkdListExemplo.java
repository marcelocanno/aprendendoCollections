package aprendendoCollectionDio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LinkdListExemplo {

	public static void main(String[] args) {
		
		
		Queue<String> filaBanco = new LinkedList<>();
		
		filaBanco.add("Mauro");
		filaBanco.add("Jose");
		filaBanco.add("Patricia");
		filaBanco.add("Guilherme");
		filaBanco.add("Luiz");
		
		System.out.println(filaBanco);
		
		String clienteSerAtendido = filaBanco.poll();
		
		System.out.println(clienteSerAtendido);
		
		System.out.println(filaBanco);
		
		///filaBanco.clear();
		
		String primeiroCliente =filaBanco.peek();
		
		System.out.println(primeiroCliente);
		
		System.out.println(filaBanco);
		
		String primeiroClienteOuErro = filaBanco.element();
		
		System.out.println(primeiroClienteOuErro);
		
		System.out.println(filaBanco);
		
		for(String cliente : filaBanco) {
			System.out.println(cliente);
		}
		
		Iterator<String> iteratorFilaBanco = filaBanco.iterator();
		
		while(iteratorFilaBanco.hasNext()) {
			System.out.println("----> " + iteratorFilaBanco.next());
		}
		
		
		System.out.println(filaBanco.size());
		
		System.out.println(filaBanco.isEmpty());
		
	}

}
