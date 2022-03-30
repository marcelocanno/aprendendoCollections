package mySqlConection;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CarroCRUD {
	
	
	private static  Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
		int op;
		while(true){
			menu();
			op = Integer.parseInt(teclado.nextLine());
			if(op == 0) {
				System.out.println("Saindo do sistma");
				break;
			}
			executar(op);
		}
	}
	
	private static void menu() {		
	}

	public static void executar(int op) throws SQLException {
		switch (op) {
		case 1 : inserir();
		break;
		case 2 : atualizar();
		break;
		case 3 : listar();
		break;
		case 4 :
			System.out.println("Digite o nome");
			buscarPorNome(teclado.nextLine());
		break;
		case 5 : deletar();
		break;
		}
	}
	private static void inserir() {
		Carro c = new Carro();
		System.out.println("Nome: ");	
		c.setNome(teclado.nextLine());
		System.out.println("Cpf: ");
		c.setPlaca(teclado.nextLine());
		System.out.println("Selecione um dos comprador abaixo");
		List<Comprador> compradorList = CompradorCRUD.listar();
		c.setComprador(compradorList.get(Integer.parseInt(teclado.nextLine())));
		CarroDAO.save(c);	
	}
	private static void atualizar() throws SQLException {
		System.out.println("Selecionar um dos carros abaixo");
		List<Carro> carroList = listar();
		Carro c = carroList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String nome = teclado.nextLine();
		System.out.println("Nova placa ou enter para manter o mesmo");
		String placa = teclado.nextLine();
		if(!nome.isEmpty()) {
			c.setNome(nome);
		}
		if(!placa.isEmpty()) {
			c.setPlaca(placa);
		}
		CarroDAO.update(c);
	}
	private static List<Carro> listar() {
		List<Carro> carroList = CarroDAO.selectAll();
		for(int i = 0; i < carroList.size(); i++) {
			Carro c = carroList.get(i);
			System.out.println("[" + i + "] " + c.getNome() + " " + c.getPlaca() + " " + c.getComprador().getNome());
		}
		return carroList;
	}
	public static void buscarPorNome (String nome) {
		List<Carro> carroList = CarroDAO.searchByName(nome);
		for(int i = 0 ; i < carroList.size(); i++) {
			Carro c = carroList.get(i);
			System.out.println("[" + i + "] " + c.getNome() + " " + c.getPlaca() + " " + c.getComprador().getNome());
		}
	}
	
	public static void deletar() {
		System.out.println("Selecione um dos carros abaixo para deletar");
		List<Carro> carroList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		System.out.println("Tem certeza: S/N");
		String op = teclado.nextLine();
		if(op.startsWith("S")) {
			CarroDAO.delete(carroList.get(index));
		}
	}

	

	
	

}
