package aprendendoCollections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializacaoTest {

	public static void main(String[] args) throws IOException {
		 
		//leitorObjeto();
		gravadorObjeto();
		//gravadorObjeto();  // apresenta exception em tempo de execução
		// no IJ não apresenta erro , copila certo
	}
	/*
	@SuppressWarnings("unused")
	private static void gravadorObjeto() {
		Aluno aluno = new Aluno(1L,"Marcelo Canno","876543");
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.ser"))){
			oos.writeObject(aluno);
		}catch (IOException e ) {
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unused")
	private static void leitorObjeto() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser"))){
			Aluno aluno =  (Aluno) ois.readObject();
			System.out.println(aluno);
			}catch (IOException |ClassNotFoundException e) {
			e.printStackTrace();
				
			}
			
			*/
		
	


	
	     // outra forma de fazer economizando linhas de codigo
	
	private static void gravadorObjeto() throws IOException {
		Aluno aluno = new Aluno(1L,"marcelo canno","987654");
		try {ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.ser"));
			oos.writeObject(aluno);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
		private static void leitorObjeto() {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser"))){
				Aluno aluno =  (Aluno) ois.readObject();
				System.out.println(aluno);
				}catch (IOException |ClassNotFoundException e) {
				e.printStackTrace();
				
				}

	}
	
	
}


