package aprendendoCollectionDio;

import java.util.Hashtable;
import java.util.Map;

public class HashTableExemplo {

	public static void main(String[] args) {
		
		Hashtable<String,Integer> estudantes = new Hashtable<>();
		 estudantes.put("Marcelo",62);
		 estudantes.put("Carla",26);
		 estudantes.put("Pedro",28);
		 estudantes.put("Ricardo",32);
		 
		System.out.println(estudantes);
		
		estudantes.put("Pedro",55);
		
		System.out.println(estudantes);
		
		estudantes.remove("Marcelo");
		
		System.out.println(estudantes);
		
		int idadeEstudantes = estudantes.get("Carla");
		
		System.out.println(idadeEstudantes);
		
		System.out.println(estudantes.size());
		
		for(Map.Entry<String, Integer> entry : estudantes.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
			
		}
		for(String Key : estudantes.keySet()) {
			System.out.println(Key + "-" + estudantes.get(Key));
		}
	}

}
