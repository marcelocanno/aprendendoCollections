package aprendendoCollectionsOne;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiExemplos  {

	

	public static void main(String[] args) {
		
		
		List<String> estudantes = new ArrayList<>();
		
		estudantes.add("Pedro");
		estudantes.add("Marcelo");
		estudantes.add("João");
		estudantes.add("Luiz");
		estudantes.add("Marina");
		estudantes.add("Heloisa");
		estudantes.add("Wagner");
		
		System.out.println(estudantes);
		
		System.out.println("Contagem : " + estudantes.stream());
		
		System.out.println("Maior numero de letras : " + estudantes.stream().max(Comparator.comparing(String::length)));
		
		System.out.println("Menor numero de letras: " + estudantes.stream().min(Comparator.comparing(String::length)));
		
		System.out.println("Com letra r no nome : " + estudantes.stream().filter(estudante -> estudante.toLowerCase().contains("r")).collect(Collectors.toList()));
		
		System.out.println("Retorna uma coleção coma quantidade de letras de cada nome : " + estudantes.stream().map(estudante -> estudante.concat(" - ").concat(String.valueOf(estudante.length()))).collect(Collectors.toList()));
		
		
		System.out.println("Retorna os três primeiros elementos ; " + estudantes.stream().limit(3).collect(Collectors.toList()));
		
		System.out.println("Retorna os elementos : " + estudantes.stream().peek(System.out::println).collect(Collectors.toList()));
		
		System.out.println("Retorna os elementos novamente");
		estudantes.stream().forEach(System.out::println);
		
		System.out.println("Todos elemento tem  a letra W no nome ? " + estudantes.stream().allMatch(elemento -> elemento.contains("w")));
		
		
		System.out.println("Tem algum elemento com a letra a minuscula no nome ? : " + estudantes.stream().anyMatch(elemento -> elemento.contains("a")));
		
		System.out.println("Não tem nenhum elemento com a letra a no nome ? " + estudantes.stream().noneMatch(elemento -> elemento.contains("a")));
		
		System.out.println("Retorna o primeiro elemento da coleção ");
		estudantes.stream().findFirst().ifPresent(System.out::println);
		
		
		System.out.print("Operação encadeada");
		System.out.println(estudantes.stream()
			.peek(System.out::println)
			.map(estudante -> 
					estudante.concat("---").concat(String.valueOf(estudante.length())))
			.peek(System.out::println)
			.filter(estudante ->
					estudante.toLowerCase().contains("r"))
			.collect(Collectors.toList()));
			//.collect(Collectors.joining(" ,")));
			//.collect(Collectors.toSet()));
			//.collect(Collectors.groupingBy(estudante -> estudante.substring(estudante.indexOf("-")+ 1))));	
	}

}
