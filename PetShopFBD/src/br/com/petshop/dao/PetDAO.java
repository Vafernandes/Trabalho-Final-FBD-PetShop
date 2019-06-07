package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.conexao.Conexao;
import br.com.petshop.modelo.Pet;

public class PetDAO {

	private Connection con = Conexao.getConnection();
	
	public void cadastrarPet(Pet pet) {
		
		String sql = "insert into pet(nome, cpf_dono, idade, especie) values(?,?,?,?)";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, pet.getNome());
			preparador.setString(2, pet.getCpfDono());
			preparador.setInt(3, pet.getIdade());
			preparador.setString(4, pet.getEspecie());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void atualizarPet(Pet pet) {
		
		String sql = "update pet set nome = ?, cpf_dono=?, idade=?, especie=? where id = ?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, pet.getNome());
			preparador.setString(2, pet.getCpfDono());
			preparador.setInt(3, pet.getIdade());
			preparador.setString(4, pet.getEspecie());
			preparador.setInt(5, pet.getId());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void deletarPet(int idPet) {
		
		String sql = "delete from pet where id = ?";
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, idPet);
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public List<Pet> listarPets(){
		
		String sql = "select * from pet";
		List<Pet> pets = new ArrayList<Pet>();
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				
				Pet petLista = new Pet();
				
				petLista.setId(resultado.getInt("id"));
				petLista.setNome(resultado.getString("nome"));
				petLista.setCpfDono(resultado.getString("cpf_dono"));
				petLista.setIdade(resultado.getInt("idade"));
				petLista.setEspecie(resultado.getString("especie"));
				
				pets.add(petLista);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return pets;
	}

	public Pet buscarPetId(int idpet) {
		String sql = "select * from pet where id = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, idpet);
			
			ResultSet resultado = preparador.executeQuery();
			resultado.next();
			
			Pet pet = new Pet(idpet, resultado.getString("nome"), resultado.getString("cpf_dono"), resultado.getInt("idade"), resultado.getString("especie"));
			
			return pet;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}return null;
	}
	
}
























