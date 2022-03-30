package mySqlConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
	
	public static void save(Carro carro) {
		String sql="INSERT INTO `agencia`. 'carro` ('nome` `placa`, `compradorId`) VALUES (?,?,?');";		
		try { Connection conn = conexaoFactory.getConexao();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, carro.getNome());
		ps.setString(2, carro.getPlaca());
		ps.setInt(3,carro.getComprador().getId());
		ps.executeUpdate();
		System.out.println("Registro inserido com sucesso");
	} catch (SQLException e) {
		e.printStackTrace();
	}	
}
	public static void delete(Carro carro) {
		if(carro == null) {
		System.out.println("Não foi possivel excluir o registro");
		return;
}
		String sql = "DELETE FROM 'agencia' .'carro' WHERE 'id' = ?";
		try {Connection conn = conexaoFactory.getConexao();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, carro.getId());
		ps.executeUpdate();
		System.out.println("Registro excuido com sucesso");
		}catch(SQLException e) {
		e.printStackTrace();
	}
}
	public static void update(Carro carro) throws SQLException {
	if(carro == null ){
		System.out.println( "Não foi possivel atualizar este registro");
		return;
	}
	String sql = "UPDATE 'agencia'. 'carro' SET 'placa' = ? , 'nome' = ? WHERE 'id' = ?";
	try{Connection conn = conexaoFactory.getConexao();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,carro.getPlaca());
		ps.setString(2,carro.getNome());
		ps.setInt(3,carro.getId());
		ps.executeUpdate();
		System.out.println("Registro inserido com sucesso");
	}catch(SQLException e ) {
		e.printStackTrace();	
	}
}
public static Comprador searchById(Integer id) {
	String sql = "Select id,nome,FROM agencia.comprador where id=?";
	Comprador comprador = null;
	try {Connection conn = conexaoFactory.getConexao();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		comprador = new Comprador(rs.getInt("id"), rs.getString("placa"), rs.getString("nome"));	
		}
		conexaoFactory.close(conn, ps,rs);
		return comprador;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
}
public static List<Carro> selectAll() {
	String sql = "SELECT id, nome, placa, compradorId FROM agencia.carro";
	List<Carro> carroList = new ArrayList<>();
	try {Connection conn = conexaoFactory.getConexao();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Comprador c = CompradorDAO.searchById(rs.getInt("compradorId"));
			carroList.add(new Carro(rs.getInt("id"),rs.getString("nome"), rs.getString("placa"),c));
			}
		return carroList;
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}	
	public static List<Carro> searchByName(String nome) {
		String sql = "Select id,nome,placa , compradorId FROM agencia.comprador where nome like ?";
		List<Carro> carroList = new ArrayList<>();
		try {Connection conn = conexaoFactory.getConexao();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,"%" + nome + "%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Comprador c = CompradorDAO.searchById(rs.getInt("compradorId"));
		carroList.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"),c));	
		}
		conexaoFactory.close(conn, ps,rs);
		return carroList;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
}
