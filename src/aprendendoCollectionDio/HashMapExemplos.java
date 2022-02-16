package aprendendoCollectionDio;

import java.util.HashMap;
import java.util.Map;

public class HashMapExemplos {

	public static void main(String[] args) {
		
		Map<String, Integer> campeoesMundiaisFifa = new HashMap<>();
		
		campeoesMundiaisFifa.put("Brasil",5);
		campeoesMundiaisFifa.put("Alemanha",4);
		campeoesMundiaisFifa.put("Italia",4);
		campeoesMundiaisFifa.put("Argentina",2);
		campeoesMundiaisFifa.put("Uruguai",2);
		campeoesMundiaisFifa.put("França",2);
		campeoesMundiaisFifa.put("Espanha",1);
		campeoesMundiaisFifa.put("Inglaterra",1);
		
		System.out.println(campeoesMundiaisFifa);
		
		campeoesMundiaisFifa.put("Brasil",6);
		
		System.out.println(campeoesMundiaisFifa);
		System.out.println(campeoesMundiaisFifa.get("Argentina"));
		
		System.out.println(campeoesMundiaisFifa.containsKey("França"));
		
		campeoesMundiaisFifa.remove("França");
		
		System.out.println(campeoesMundiaisFifa.containsKey("França"));
		
		System.out.println(campeoesMundiaisFifa.containsValue(6));
		
		System.out.println(campeoesMundiaisFifa.size());
		
		System.out.println(campeoesMundiaisFifa);
		
		for(Map.Entry<String,Integer> entry : campeoesMundiaisFifa.entrySet()) {
			System.out.println(entry.getKey() + "--" + entry.getValue());
		}
		
		for(String Key : campeoesMundiaisFifa.keySet()) {
			System.out.println(Key + "---" + campeoesMundiaisFifa.get(Key));
		}
		
		System.out.println(campeoesMundiaisFifa);
		
		System.out.println(campeoesMundiaisFifa.containsKey("Estados Unidos"));
		
		System.out.println(campeoesMundiaisFifa.containsValue(5));
		
		System.out.println(campeoesMundiaisFifa.size());
		
		//campeoesMundiaisFifa.clear();
		
		System.out.println(campeoesMundiaisFifa);
	}

}
