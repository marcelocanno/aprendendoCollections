package aprendendoCollectionsOne;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorsExampleList {

	public static void main(String[] args) {
			
		List<Estudante> estudantes = new ArrayList<>();
		
		estudantes.add(new Estudante("Pedro", 19));		
		estudantes.add(new Estudante("Marcelo", 22));
		estudantes.add(new Estudante("Julio", 18));
		estudantes.add(new Estudante("Marilia", 21));
		estudantes.add(new Estudante("Jorge", 20));
		estudantes.add(new Estudante("Luiz", 23));
		estudantes.add(new Estudante("Caio", 24));
		estudantes.add(new Estudante("Andre", 25));
		
		System.out.println("ordem de inserção");
		System.out.println(estudantes);
		
		System.out.println("------------------------------------------------------------------------");
		
		estudantes.sort((first, second) -> first.getIdade() - second.getIdade());
		
		System.out.println("Ordem natural dos numeros - idade ");
		System.out.println(estudantes);
		
		System.out.println("------------------------------------------------------------------------");
		
		estudantes.sort((first, second) -> second.getIdade() - first.getIdade());
		System.out.println("Ordem reversa dos numeros - idade");
		System.out.println(estudantes);
		
		System.out.println("------------------------------------------------------------------------");
		
		estudantes.sort(Comparator.comparingInt(Estudante::getIdade));
		System.out.println("Ordem natural dos numeros - idade (method reference)");
		System.out.println(estudantes);
		
		System.out.println("------------------------------------------------------------------------");
		
		estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());
		System.out.println("Ordem natural dos numeros - idade (method reference)");
		System.out.println(estudantes);
		
		System.out.println("------------------------------------------------------------------------");
		
		Collections.sort(estudantes);
		System.out.println("Ordem natural dos numeros - idade (interface comparable)");
		System.out.println(estudantes);
		
		System.out.println("------------------------------------------------------------------------");
		
		Collections.sort(estudantes, new EstudanteOrdemIdadeReversaComparator());
		System.out.println("Ordem natural dos numeros - idade (interface comparator)");
		System.out.println(estudantes);
		
		System.out.println("------------------------------------------------------------------------");	
	}

}
