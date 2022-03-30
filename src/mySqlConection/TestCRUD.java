package mySqlConection;

import java.sql.SQLException;
import java.util.Scanner;

public class TestCRUD {
	
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
			if(op == 1) {
				menuComprador();
				op = Integer.parseInt(teclado.nextLine());
				CompradorCRUD.executar(op);
			}
			if(op == 2) {
				menuCarro();
				op = Integer.parseInt(teclado.nextLine());
				CarroCRUD.executar(op);
			}
			
		}
	}
	
	private static void menu() {
		System.out.println("Selecione uma opção");
		System.out.println("1. Comprador");
		System.out.println("2. Carro");
		System.out.println("0. Sair");
	}
	/*
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
		Comprador c = new Comprador();
		System.out.println("Nome: ");	
		c.setNome(teclado.nextLine());
		System.out.println("Cpf: ");
		c.setCpf(teclado.nextLine());
		CompradorDAO.save(c);	
	}
	private static void atualizar() throws SQLException {
		System.out.println("Selecionar um dos compradores abaixo");
		List<Comprador> compradorList = listar();
		Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String nome = teclado.nextLine();
		System.out.println("Novo cpf ou enter para manter o mesmo");
		String cpf = teclado.nextLine();
		if(!nome.isEmpty()) {
			c.setNome(nome);
		}
		if(!cpf.isEmpty()) {
			c.setCpf(cpf);
		}
		CompradorDAO.update(c);
	}
	private static List<Comprador> listar() {
		List<Comprador> compradorList = CompradorDAO.selectAll();
		for(int i = 0; i < compradorList.size(); i++) {
			Comprador c = compradorList.get(i);
			System.out.println("[" + i + "] " + c.getNome() + " " + c.getCpf());
		}
		return compradorList;
	}
	public static void buscarPorNome (String nome) {
		List<Comprador> compradorList = CompradorDAO.searchByName(nome);
		for(int i = 0 ; i < compradorList.size(); i++) {
			Comprador c = compradorList.get(i);
			System.out.println("[" + i + "] " + c.getNome() + " " + c.getCpf());
		}
	}
	
	public static void deletar() {
		System.out.println("Selecione um dos compradores abaixo para deletar");
		List<Comprador> compradorList = listar();
		int index = Integer.parseInt(teclado.nextLine());
		System.out.println("Tem certeza: S/N");
		String op = teclado.nextLine();
		if(op.startsWith("S")) {
			CompradorDAO.delete(compradorList.get(index));
		}
	}
	*/
	private static void menuComprador() {
		System.out.println("digite a opção para começar");
		System.out.println("1. Inserir comprador");
		System.out.println("2. Atualizar comprador");
		System.out.println("3. Listar todos os compradores");
		System.out.println("4. Buscar comprador por nome");
		System.out.println("5.Deletar");
		System.out.println("9. Voltar");	
	}

	private static void menuCarro() {
		System.out.println("digite a opção para começar");
		System.out.println("1. Inserir carro");
		System.out.println("2. Atualizar carro");
		System.out.println("3. Listar todos os carro");
		System.out.println("4. Buscar carro por nome");
		System.out.println("5.Deletar");
		System.out.println("9. Voltar");	
	}
}
