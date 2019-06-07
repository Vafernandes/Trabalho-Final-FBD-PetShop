package br.com.petshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.petshop.conexao.Conexao;
import br.com.petshop.modelo.Venda;

public class VendaDAO {

	private Connection con = Conexao.getConnection();

	public void cadastrarVenda(Venda venda) {

		String sql = "insert into venda(cpf_cliente,id_pet,id_servico) values(?,?,?)";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			preparador.setString(1, venda.getCpfCliente());
			preparador.setInt(2, venda.getIdPet());
			preparador.setInt(3, venda.getIdServico());
			// preparador.setDouble(4, venda.getValor());

			preparador.execute();
			preparador.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void valorDaCompra(String cpf) {

		String sql = "select sum(s.preco) from servico s, venda v where s.id = v.id_servico and v.cpf_cliente = ?";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cpf);

			ResultSet resultado = preparador.executeQuery();
			resultado.next();

			float valor = resultado.getFloat(1);
			System.out.println("O valor da compra foi de: " + valor + "R$");

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void deletar(int idVenda) {

		String sql = "delete from venda where id = ?";

		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, idVenda);

			preparador.execute();
			preparador.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<Venda> listarVendas() {

		String sql = "select * from venda";
		List<Venda> vendas = new ArrayList<Venda>();

		try {

			PreparedStatement preparador = con.prepareStatement(sql);

			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Venda vendaL = new Venda();

				vendaL.setId(resultado.getInt("id"));
				vendaL.setCpfCliente(resultado.getString("cpf_cliente"));
				vendaL.setIdPet(resultado.getInt("id_pet"));
				vendaL.setIdServico(resultado.getInt("id_Servico"));

				vendas.add(vendaL);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return vendas;

	}

	public Venda buscar(int idVenda) {
		String sql = "select * from venda where id = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, idVenda);
			
			ResultSet resultado = preparador.executeQuery();
			resultado.next();
			
			Venda venda = new Venda(resultado.getInt("id"), resultado.getString("cpf_cliente"),
					resultado.getInt("id_pet"),resultado.getInt("id_Servico"));
			
			return venda;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}return null;
	}
	
}
