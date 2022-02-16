package aprendendoCollectionDio;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorExemplo {

	public static void main(String[] args) {
		
		List<String> esportes = new Vector<>();
		
		esportes.add("futebol");
		esportes.add("Basquete");
		esportes.add("Tenis");
		esportes.add("Handebol");
		
		System.out.println(esportes);
		
		esportes.set(2,"Ping-Pong");
		
		System.out.println("++++>>> " + esportes);
		
		Collections.sort(esportes);
		
		System.out.println(esportes);
		
		esportes.remove(2);
		
		System.out.println("---> " + esportes);
		
		esportes.remove("Tenis");
		
		System.out.println("--->> " + esportes.get(1));
		
		for(String esporte : esportes) {
			System.out.println("---> " + esporte);
		}
		
	}

}
