package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;

public class ClienteDAO {

	public void create(Cliente f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE (nome, cpf, endereço, EstadoCivil) VALUES"
					+ "(?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getEmail());
			stmt.setBoolean(3, f.isSexo());

			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Salvo com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public List<Cliente> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente f = new Cliente();
				f.setIdCliente(rs.getInt("idCliente"));
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setSexo(rs.getBoolean("sexo"));
				clientes.add(f);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return clientes;
	}

}