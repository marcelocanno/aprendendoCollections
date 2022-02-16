package mySqlConection;

import java.sql.Connection;
import java.sql.SQLException;

public class testConexao {
	 
		/*
		public static void main(String[] args) throws SQLException {
			Class<conexaoFactory> conexao = conexaoFactory.class;
			
		CompradorDB.selectMetaData();
		*/
		
		public static void main(String[] args) throws SQLException {
			 conexaoFactory conn = new conexaoFactory();
			 conexaoFactory.getConexao();
		
			 CompradorDB.selectMetaData();
			
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
	
		
