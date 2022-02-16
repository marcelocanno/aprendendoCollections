package mySqlConection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompradorDB {                   
	
	
	// executado pela aula Java 7, os comandos mudaram
    // update, delete, insert, consulte.
	// fazer aulas expecifica de sql e voltar e corrigir
	                  
	public static void main(String[] args) {
		/*
		String save;
			String sql="INSERT INTO `agencia`.`comprador` (`id`, `cpf`, `nome`) VALUES ('7', '989.987.543.66', 'Julio');\n";
		
			Connection conexaoFactory = null;
			Connection conn = conexaoFactory;
		
			try {
			Statement stmt = conn.createStatement();
			stmt.execute(sql);  // executa alterações de inserir, deletar, consultar, etc
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
		*/
	}
	public void update(Comprador comprador) throws SQLException {
		String sql = "INSERT INTO `agencia`.`comprador` (`id`, `cpf`, `nome`) VALUES ('7', '989.987.543.66', 'Julio');\n";
		Class<conexaoFactory> conn = conexaoFactory.class;
		Statement stmt = Statement();
	
	}

	private Statement Statement() {
		return null;
	}
	
	public static List<Comprador> searchByName(String nome) throws SQLException{
		String sql = "Select id,nome,FROM agencia.comprador where nome like 's"+nome+"s'";
		Connection conn = conexaoFactory.getConexao();
		List<Comprador> compradorList = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
			compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));	
			}
			conexaoFactory.close(conn, stmt,rs);
			return compradorList;
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return null;		
	}
	
	
		// meta dados apresenta exception dificuldade com sql
		// resolução futura
	
		public static void selectMetaData() throws SQLException {
			
			String sql = "SELECT * FROM agencia,comprador";
			Connection conn = conexaoFactory.getConexao();
			try{
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmd = rs.getMetaData();
				rs.next();
				int gtdColunas = rsmd.getColumnCount();
			System.out.println("Quantidades de colunas" + gtdColunas);
			for(int i = 1; i<= gtdColunas; i++) {
				System.out.println("Tabela" + rsmd.getTableName(i));
				System.out.println("Nome Coluna : " + rsmd.getCatalogName(i));
				System.out.println("Tamanho coluna: " + rsmd.getColumnDisplaySize(i));
			}
			
			conexaoFactory.close(conn, stmt, rs);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
}
 