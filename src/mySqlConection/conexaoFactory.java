package mySqlConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;


public class conexaoFactory {
	
	// java jdbc
	// java sql  
	// abaixo todas as interfaces
	// Connection - configura conecção BD - buscar e receber a conexão
	// Statement - trabalhar com dados do banco que irão afetar seu desempenho
	// ResultSet - selecionar os dados e utiliza los na aplicação - trabalha com os resultados
	// DriveManeger - classe concreta , vai buscar conector e trazer a conecção para vc
	
	public static  Connection getConexao() throws SQLException {
		
		String url = "jdbc:mysql://canno:3306/agencia?useSSL=false";
		String user = "root";
		String password = "satan666";
		try {
			
			//return DriverManager.getConnection(url, user, password);
			//Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
			return connection;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
        public static  JdbcRowSet getRowSetConnetion() throws SQLException {
		
		String url = "jdbc:mysql://canno:3306/agencia?useSSL=false";
		String user = "root";
		String password = "satan666";
		try {
			JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
			jdbcRowSet.setUrl(url);
			jdbcRowSet.setUsername(user);
			jdbcRowSet.setPassword(password);
			return jdbcRowSet;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public static JdbcRowSet getRowSetConnection() {
		String url = "jdbc:mysql://canno:3306/agencia?useSSL=false";
		String user = "root";
		String password = "satan666";
		try {
			JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
			jdbcRowSet.setUrl(url);
			jdbcRowSet.setUsername(user);
			jdbcRowSet.setPassword(password);
			return jdbcRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static CachedRowSet getRowSetConnectionCached() {
		String url = "jdbc:mysql://canno:3306/agencia?useSSL=false relaxAutocommit=true";
		String user = "root";
		String password = "satan666";
		try {
			CachedRowSet cachedRowSet =  RowSetProvider.newFactory().createCachedRowSet();
			cachedRowSet.setUrl(url);
			cachedRowSet.setUsername(user);
	
			cachedRowSet.setPassword(password);
			return cachedRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}		
	public void fecharConexao(Connection connection) {
		try {
			if(connection != null)
				connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection connection , Statement stmt, ResultSet rs) {
		close(connection, stmt, rs);
		try {
			if(stmt != null)
				stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection connection, PreparedStatement ps) {
		try {
			if(connection != null)
				connection.close();			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	public static void close(JdbcRowSet jrs) {
		try {
			if(jrs != null)
				jrs.close();			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
}