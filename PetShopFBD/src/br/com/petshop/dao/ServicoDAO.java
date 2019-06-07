		package br.com.petshop.dao;
		
		import java.sql.Connection;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.util.ArrayList;
		import java.util.List;
		
		import br.com.petshop.conexao.Conexao;
		import br.com.petshop.modelo.Servico;
		
		
		public class ServicoDAO {
		
		private Connection con = Conexao.getConnection();
			
			public void cadastrarServico(Servico servico) {
				
				String sql = "insert into servico(nome, preco) values(?,?)";
				
				try {
					
					PreparedStatement preparador = con.prepareStatement(sql);
					preparador.setString(1, servico.getNome());
					preparador.setDouble(2, servico.getPreco());
					
					
					preparador.execute();
					preparador.close();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
			public void atualizarServico(Servico servico) {
				
				String sql = "update servico set nome = ?, preco = ? where id = ?";
				
				try {
					
					PreparedStatement preparador = con.prepareStatement(sql);
					
					preparador.setString(1, servico.getNome());
					preparador.setDouble(2, servico.getPreco());
					preparador.setInt(3, servico.getId());
					
					preparador.execute();
					preparador.close();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
			public void deletarServico(int idServ) {
				
				String sql = "delete from servico where id = ?";
				
				try {
					
					PreparedStatement preparador = con.prepareStatement(sql);
					
					preparador.setInt(1, idServ);
					
					preparador.execute();
					preparador.close();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
			public List<Servico> listarServicos(Servico servico){
				
				String sql = "select * from servico";
				List<Servico> servicos = new ArrayList<Servico>();
				
				try {
					
					PreparedStatement preparador = con.prepareStatement(sql);
					
					ResultSet resultado = preparador.executeQuery();
					
					while(resultado.next()) {
						
						Servico servicoLista = new Servico();
						
						servicoLista.setId(resultado.getInt("id"));
						servicoLista.setNome(resultado.getString("nome"));
						servicoLista.setPreco(resultado.getDouble("preco"));
						
						servicos.add(servicoLista);
					}
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				
				return servicos;
			}
			
			public Servico buscarServicoID(int idServico) {
				String sql = "select * from servico where id = ?";
				
				try {
					PreparedStatement preparador = con.prepareStatement(sql);
					
					preparador.setInt(1, idServico);
					
					ResultSet resultado = preparador.executeQuery();
					resultado.next();
					
					Servico servico = new Servico(idServico, resultado.getString("nome"), resultado.getDouble("preco"));
					return servico;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}return null;
			}
		}
