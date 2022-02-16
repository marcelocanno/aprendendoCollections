package aprendendoCollections;

import java.util.ArrayList;
import java.util.List;

public class ListCelularTest extends Celular {

	public ListCelularTest(String nome, String iMEI) {
		super(nome, iMEI);
		
	}

	public static void main(String[] args) {
			
			Celular celular1 = new Celular("galaxy", "1123455");
			Celular celular2 = new Celular("Ifone" , "768576");
			Celular celular3 = new Celular("Sony" , "9876544");
			Celular celular4 = new Celular("galaxy","1123455");
			List<Celular> celularList = new ArrayList<>();
			celularList.add(celular1);
			celularList.add(celular2);
			celularList.add(celular3);
			celularList.add(celular4);
		
			
			//  simulando println
			
			for(Celular celular : celularList) {
				System.out.println(celular);
				//System.out.println("----------------------------------");
				//System.out.println(celular.getNome());
				//System.out.println("----------------------------------");
				//System.out.println(celular.getIMEI());
				//System.out.println("----------------------------------");
				//System.out.println(celular);
			}
			//Celular celular4 = new Celular("galaxy","1123455");
			System.out.println(celularList.contains(celular4));
			System.out.println(celular1.equals(celular4));
		
	}

}
