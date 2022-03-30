package mySqlConection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("unused")
public class testConexao {
	 
		
		public static void main(String[] args) throws SQLException {
			Class<conexaoFactory> conexao = conexaoFactory.class;
		
	
		//deletar();
		//atualizar();
		//List<Comprador> listComprador = selecionarTudo();
		//List<Comprador> listComprador = buscarPorNome();
		//System.out.println(listaComprador);
		//System.out.println(listaComprador2);
		//CompradorDB.selectMetaData();
		//CompradorDB.checkDriverStatus();
		//CompradorDB.testTypeScroll();
		//CompradorDB.updateNomesLowerCase();
		//System.out.println(CompradorDB.searchByNameRowSet("nome"));
		//System.out.println(CompradorDB.searchByNamepreparedStatement("marcelo"));
		//System.out.println(CompradorDB.searchByName("Luiz"));
		//System.out.println(CompradorDB.selectAll());
		//CompradorDB.updatePreparedStatement(new Comprador(1,"987.985.999-99","Ruas"));
		//CompradorDB.updateRowSet(new Comprador(3,"111.666.777-77", "Barbara"));
		//CompradorDB.updateRowSetCached(new Comprador(1,"111.000.666-66", "Dive"));
		//CompradorDB.saveTrassaction(null);
		
		
		/*
		public static void main(String[] args) throws SQLException {
			 conexaoFactory conn = new conexaoFactory();
			 conexaoFactory.getConexao();
		*/
			 
			
		}
		
		public static void inserir() {
			Comprador comprador = new Comprador(23, "111.111.345-34","Caio");
			comprador.setNome("comprador");
		}
		public static void delete() throws SQLException {
			Comprador comprador = new Comprador();
			comprador.setId(2);
			CompradorDB.delete(comprador);
		}
		public static void atualizar() throws SQLException {
			Comprador comprador = new Comprador(31, "234.567.808-45", "Osmar");
			CompradorDB.searchByName("comprador");
		}
		public static List<Comprador> selecionarTudo() throws SQLException{
			return CompradorDB.selectMetaData();
		}
		public static List<Comprador> selecionarPorNome() throws SQLException{
			return CompradorDB.searchByName("nome");
		}
}	










	// banco não está conectano devido configuração da porta.
	/*
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
	
		conexaoFactory conexao = new conexaoFactory();
		conexao.getConexao();
		try {
			try {
				try {
					Connection conexao = conexaoFactory.getConexao();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		conexao.close();
				
		try {
		conexaoFactory conexaoFactory = new conexaoFactory();
		conexaoFactory.getConexao();
		} catch (SQLException e) {
		
		e.printStackTrace();
		}
	
	}
}
	
	
	/*
	
	public interface ConexaoFactory {

	}
		
		@SuppressWarnings("unused")
		ConexaoFactory conn = new testConexao.ConexaoFactory() {
		};
	
	*/
	
		
