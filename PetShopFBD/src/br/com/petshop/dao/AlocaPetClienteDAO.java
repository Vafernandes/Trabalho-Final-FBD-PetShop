package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.conexao.Conexao;
import br.com.petshop.modelo.AlocarPetCliente;

public class AlocaPetClienteDAO {

	private Connection con = Conexao.getConnection();
	
	public void alocarPetCliente(AlocarPetCliente alocar) {
		
		String sql = "insert into adicionarpetcliente(cpf_cliente, id_pet) values(?,?)";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, alocar.getCpfCliente());
			preparador.setInt(2, alocar.getIdPet());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void atualizarAlocaPetCli(AlocarPetCliente alocar) {
		
		String sql = "update adicionarpetcliente set nome = ?, preco = ? where cpf = ?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, alocar.getCpfCliente());
			preparador.setInt(2, alocar.getIdPet());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void deletarAlocacao(String cpfCliente) {
		
		String sql = "delete from adicionarpetcliente where cpf_cliente = ?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, cpfCliente);
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public List<AlocarPetCliente> listarAlocacoes(){
		
		String sql = "select * from adicionarpetcliente";
		List<AlocarPetCliente> alocacoes = new ArrayList<AlocarPetCliente>();
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				
				AlocarPetCliente aloca = new AlocarPetCliente();
				
				aloca.setCpfCliente(resultado.getString("cpf_cliente"));
				aloca.setIdPet(resultado.getInt("id_pet"));
				
				alocacoes.add(aloca);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return alocacoes;
	}
	
	public AlocarPetCliente buscarAlocacaoCPF(String cpf) {
		String sql = "select * from adicionarpetcliente where cpf_cliente = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, cpf);
			
			ResultSet resultado = preparador.executeQuery();
			resultado.next();
			
			AlocarPetCliente alocar = new AlocarPetCliente(cpf, resultado.getInt("id_pet"));
			return alocar;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}return null;
	}
	
}
