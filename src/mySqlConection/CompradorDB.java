package mySqlConection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;



public class CompradorDB {                   
	
	
	// executado pela aula Java 7, os comandos mudaram
    // update, delete, insert, consulte.
	// fazer aulas expecifica de sql e voltar e corrigir
	                  
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		String save;
			String sql="INSERT INTO `agencia`.`comprador` (`id`, `cpf`, `nome`) VALUES ('7', '989.987.543.66', 'Julio');\n";
		
			Connection conexaoFactory = null;
			Connection conn = conexaoFactory;
		
			try {
			@SuppressWarnings("null")
			Statement stmt = conn.createStatement();
			stmt.execute(sql);  // executa alterações de inserir, deletar, consultar, etc
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public static void saveTrassaction() throws SQLException {
		String sql = "INSERT INTO 'agencia' . 'comprador' ('cpf' , 'nome') VALUES ('TESTE1' , 'TESTE1'";
		String sql2 = "INSERT INTO 'agencia' . 'comprador' ('cpf' , 'nome') VALUES ('TESTE2' , 'TESTE2'";
		String sql3= "INSERT INTO 'agencia' . 'comprador' ('cpf' , 'nome') VALUES ('TESTE3' , 'TESTE3'";
		String sql4 = "INSERT INTO 'agencia' . 'comprador' ('cpf' , 'nome') VALUES ('TESTE4' , 'TESTE4'";
		Connection conn = conexaoFactory.getConexao();
		try {
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			conn.commit();
			conn.setAutoCommit(true);
			conexaoFactory.close(conn, stmt, null);
			System.out.println("");
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		
	}
	
	public static void delete(Comprador comprador) throws SQLException {
		if(comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel excluir o registro");
			return;
		}
		String sql = "DELETE FROM 'agencia' , 'comprador' WHERE 'ID' ='" + comprador.getId()+"'";
		Connection conn = conexaoFactory.getConexao();
		try {
			Statement stmt = conn.createStatement();
			stmt.executeLargeUpdate(sql);
			conexaoFactory.close(conn, stmt, null);
			System.out.println("Registro excuido com sucesso");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(Comprador comprador) throws SQLException {
		@SuppressWarnings("unused")
		String sql = "INSERT INTO `agencia`.`comprador` (`id`, `cpf`, `nome`) VALUES ('7', '989.987.543.66', 'Julio');\n";
		@SuppressWarnings("unused")
		Class<conexaoFactory> conn = conexaoFactory.class;
		@SuppressWarnings("unused")
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
	
		public static List<Comprador> selectMetaData() throws SQLException {
			
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
			return null;
		}

		public static void checkDriverStatus() throws SQLException {
			Connection conn = conexaoFactory.getConexao();
			try {
				DatabaseMetaData dbmd = conn.getMetaData();
				if(dbmd.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
					System.out.println("Suporta TYPE_FORWARD_ONLY");
					if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
						System.out.println("e também suporta CONCUR_UPDATABLE");
					}	
				}
				if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
					System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");
					if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
						System.out.println("e também suporta CONCUR_UPDATABLE");
					}
				}
				if(dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
						System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
						if(dbmd.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
							System.out.println("e também suporta CONCUR_UPDATABLE");
					}			
				}
			conexaoFactory.close(conn, null, null);;
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static List<Comprador> selectAll() throws SQLException{
			String sql = "SELECT id, nome, cpf FROM agencia.comprador";
			Connection conn = conexaoFactory.getConexao();
			List<Comprador> compradorList = new ArrayList<>();
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					compradorList.add(new Comprador(rs.getInt("id"),rs.getString("cpf"), rs.getString("nome")));
					}
				conexaoFactory.close(conn, stmt, rs);
				return compradorList;
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		/*
		public static void testTypeScroll() throws SQLException{
			String sql = "SELECT id, nome, cpf FROM agencia.comprador";
			Connection conn = conexaoFactory.getConexao();
			try {
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					System.out.println(new Comprador(rs.getInt("id"),rs.getString("cpf"), rs.getString("nome")));
					}
				conexaoFactory.close(conn, stmt, rs);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		*/
		public static void testTypeScroll() throws SQLException{
			String sql = "SELECT id, nome, cpf FROM agencia.comprador";
			Connection conn = conexaoFactory.getConexao();
			try {
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.last()) {
					System.out.println("Ultima linha"+new Comprador(rs.getInt("id"),rs.getString("cpf"), rs.getString("nome")));
					System.out.println("Numero ultima linha" + rs.getRow());
					}
				System.out.println("Retorna para a primeira linha" + rs.first());
				System.out.println("Primeira linha" + rs.getRow());
				rs.absolute(2);    // apresenta os dados da linha expecifica
				System.out.println(" Linha 2" + new Comprador(rs.getInt("id"),rs.getString("cpf"), rs.getString("nome")));
				rs.relative(-1);    // apresenta os dados da linha expecifica nemos 1
				System.out.println(" Linha 1" + new Comprador(rs.getInt("id"),rs.getString("cpf"), rs.getString("nome")));
				System.out.println(rs.isAfterLast());
				System.out.println(rs.isLast());
				System.out.println(rs.isLast());  // diversas formas de você saber onde esta o curso dentro da tabela
				rs.last();       //printa todos os registros menos onde está o cursor
				rs.afterLast();  //printa todos os registros inclusive onde esta o cursor
				System.out.println("----------------------------------------------");
				while(rs.previous()) {
					System.out.println(new Comprador(rs.getInt("id"),rs.getString("cpf"), rs.getString("nome")));
					System.out.println(new Comprador(rs.getInt("id"),rs.getString("cpf"), rs.getString("nome")));
				}
				conexaoFactory.close(conn, stmt, rs);
			}catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		
		public static void updateNomesLowerCase() throws SQLException {
			String sql = "SELECT id , nome, cpf FROM agencia.comprador";
			Connection conn = conexaoFactory.getConexao();
			try {
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					rs.updateString("nome",rs.getString("nome").toLowerCase());
					rs.updateRow();
				}
				rs.beforeFirst();
				while(rs.next()) {
					System.out.println(rs.getString("nome"));
				}
				rs.absolute(2);
				String nome = rs.getString("nome");
				rs.moveToInsertRow();
				rs.updateString("nome", nome.toUpperCase());
				rs.updateString("cpf","876.999.888-12");
				rs.insertRow();
				rs.moveToCurrentRow();
				System.out.println("nome" + "row " + rs.getRow());
			conexaoFactory.close(conn, stmt, rs);
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		
		
		public static List<Comprador> searchByNamepreparedStatement(String nome) throws SQLException{
			String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?";
			Connection conn = conexaoFactory.getConexao();
			List<Comprador> compradorList = new ArrayList<>();
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,"nome");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					compradorList.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
				}
				conexaoFactory.close(conn, ps, rs);
				return compradorList;
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			}
		
		public static List<Comprador> searchByNameRowSet(String nome) throws SQLException{
			String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?";
			JdbcRowSet jrs = conexaoFactory.getRowSetConnection();
			jrs.addRowSetListener(new MyRowSetListener());
			List<Comprador> compradorList = new ArrayList<>();
			try {
				jrs.setCommand(sql);
				jrs.setString(1, "nome" );
				jrs.execute();
				
				while (jrs.next()) {
					compradorList.add(new Comprador(jrs.getInt("id"), jrs.getString("cpf"), jrs.getString("nome")));
				}
				conexaoFactory.close(jrs);
				return compradorList;
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
			}
		
		public static void updatePreparedStatement(Comprador comprador) throws SQLException {
			if(comprador == null || comprador.getId() == null ) {
				System.out.println("Não foi possivel atualizar o registro");
				return;				
			}
			String sql = "UPDATE 'agencia' = 'comprador' SET 'cpf' = ? WHERE 'id' = ? ";
			Connection conn = conexaoFactory.getConexao();
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1,comprador.getCpf());
				ps.setString(2,comprador.getNome());
				ps.setInt(3,comprador.getId());
				ps.executeUpdate();
				conexaoFactory.close(conn,ps);
				System.out.println("Registro atualizado com sucesso");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void updateRowSet(Comprador comprador) throws SQLException {
			if(comprador == null || comprador.getId() == null ) {
				System.out.println("Não foi possivel atualizar o registro");
				return;				
			}
			//String sql = "UPDATE 'agencia' = 'comprador' SET 'cpf' = ? WHERE 'id' = ? ";
			String sql = "SELECT * FROM comprador where id = ? ";
			JdbcRowSet jrs = conexaoFactory.getRowSetConnection();
			jrs.addRowSetListener(new MyRowSetListener());
			try {
				jrs.setCommand(sql);
				//jrs.setCommand(sql);
				//jrs.setString(1,comprador.getCpf());
				//jrs.setString(2,comprador.getNome());
				jrs.setInt(3,comprador.getId());
				jrs.execute();
				jrs.next();
				jrs.updateString("nome","Marcelo");
				jrs.updateRow();
				conexaoFactory.close(jrs);
				System.out.println("Registro atualizado com sucesso");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void updateRowSetCached(Comprador comprador) throws SQLException {
			if(comprador == null || comprador.getId() == null ) {
				System.out.println("Não foi possivel atualizar o registro");
				return;				
			}
			String sql = "SELECT * FROM comprador where id = ? ";
			CachedRowSet crs = conexaoFactory.getRowSetConnectionCached();
			try {
				crs.setCommand(sql);
				crs.setInt(1,comprador.getId());
				crs.execute();
				crs.next();
				crs.updateString("nome","Dive");
				crs.updateRow();
				crs.acceptChanges();
				System.out.println("Registro atualizado com sucesso");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
		
		
		
		