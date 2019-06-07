package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.conexao.Conexao;
import br.com.petshop.modelo.Cliente;

public class ClienteDAO {
	
	private Connection con = Conexao.getConnection();
	
	public void cadastrar(Cliente cliente) {
		String sql = "insert into cliente(nome,cpf,endereco) values(?, ?, ?)";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setString(3,  cliente.getEndereco());
			
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void alterarCli(Cliente cliente) {
		
		String sql = "update cliente set nome = ?, cpf = ?, endereco = ? where cpf = ?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setString(3, cliente.getEndereco());
			preparador.setString(4, cliente.getCpf());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void deletarCli(String cpf) {
		
		String sql = "delete from cliente where cpf = ?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cpf);
			
			preparador.execute();
			preparador.close();
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public List<Cliente> listarClientes(){
		
		String sql = "select * from cliente";
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				Cliente cliListaResultados = new Cliente();
				
				cliListaResultados.setId(resultado.getInt("id"));
				cliListaResultados.setNome(resultado.getString("nome"));
				cliListaResultados.setCpf(resultado.getString("cpf"));
				cliListaResultados.setEndereco(resultado.getString("endereco"));
				
				clientes.add(cliListaResultados);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return clientes;
		
		
		
	}
	
	
	public Cliente buscarClienteCpf(String cpfCliente) {
		String sql = "select * from cliente where cpf = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, cpfCliente);
			
			ResultSet resultado = preparador.executeQuery();
			resultado.next();
			
			Cliente cliente = new Cliente(resultado.getInt("id"), resultado.getString("nome"), 
					cpfCliente, resultado.getString("endereco"));
			
			return cliente;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}return null;
	}
	
	
	
	
	

}
