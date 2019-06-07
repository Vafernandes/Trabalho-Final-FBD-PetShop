package br.com.petshop.main;

import java.util.List;
import java.util.Scanner;

import br.com.petshop.dao.AlocaPetClienteDAO;
import br.com.petshop.dao.ClienteDAO;
import br.com.petshop.dao.PetDAO;
import br.com.petshop.dao.ServicoDAO;
import br.com.petshop.dao.VendaDAO;
import br.com.petshop.modelo.AlocarPetCliente;
import br.com.petshop.modelo.Cliente;
import br.com.petshop.modelo.Pet;
import br.com.petshop.modelo.Servico;
import br.com.petshop.modelo.Venda;

public class Main {

	private static Scanner input;

	public static void help() {
		System.out.println("---------- I need somebody HELP! ----------\n\n"
				+ "------------ CLIENTE --------------------|\n\n" 
				+ " 1 - Cadastrar Cliente                   |\n"
				+ " 2 - Alterar Cliente                     |\n" 
				+ " 3 - Deletar Cliente                     |\n"
				+ " 4 - Listar Todos os Clientes            |\n" 
				+ " 5 - Bsscar Cliente pelo CPF             |\n\n"
				+ "-------------- PET ----------------------|\n\n" 
				+ " 6 - Cadastrar Pet                       |\n"
				+ " 7 - Atualizar PET                       |\n" 
				+ " 8 - Deletar PET                         |\n"
				+ " 9 - Listar todos os PETs                |\n" 
				+ " 10 - Buscar PET pelo ID                 |\n\n"
				+ "------------ SERVIÇO --------------------|\n\n" 
				+ " 11 - Cadastrar Serviço                  |\n"
				+ " 12 - Atualizar Serviço                  |\n" 
				+ " 13 - Deletar Serviço                    |\n"
				+ " 14 - Listar Todos Os Serviços           |\n" 
				+ " 15 - Buscar Serviço pelo ID             |\n\n"
				+ "----------- ALOCAR PET CLIENTE ----------|\n\n" 
				+ " 16 - Alocar pet ao cliente              |\n"
				+ " 17 - Alterar Alocação                   |\n" 
				+ " 18 - Deletar Alocação                   |\n"
				+ " 19 - Listar Alocações                   |\n" 
				+ " 20 - Buscar Alocação pelo CPF           |\n\n"
				+ "----------------- VENDA -----------------|\n\n" 
				+ " 21 - Cadastrar Venda                    |\n"
				+ " 22 - mostrar o valor da compra do clien |\n"
				+ " 23 - Listar Vendas                      |\n"
				+ " 24 - Deletar Venda                      |\n"
				+ " 25 - Buscar venda por ID                |\n\n");
	};

	public static void main(String[] args) {

		input = new Scanner(System.in);
		
		ClienteDAO cliDAO = new ClienteDAO();
		PetDAO petDAO = new PetDAO();
		ServicoDAO servDAO = new ServicoDAO();
		AlocaPetClienteDAO alocarDAO = new AlocaPetClienteDAO();
		VendaDAO vendaDAO = new VendaDAO();
		
		String nome, cpf, especie, endereco;
		int id, idade;
		double preco;

		boolean sair = false;

		while (!sair) {

			System.out.println("Digite '0' para acessar o menu");
			System.out.print("Opção>>");
			int opcao = Integer.parseInt(input.nextLine());

			switch (opcao) {
			case 0:
				help();
				break;
			case 1:

				System.out.println("\nCadastrar Cliente\n");

				System.out.print("Informe o nome: ");
				nome = input.nextLine();
				System.out.print("Informe o CPF: ");
				cpf = input.nextLine();
				System.out.print("Informe o endereço: ");
				endereco = input.nextLine();
				
				try {
					
					cliDAO.cadastrar(new Cliente(nome,cpf,endereco));
					System.out.println("Cadastrado com sucesso!");
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 2:
				System.out.println("\nAlterar dados do cliente\n");

				System.out.print("Infome o CPF: ");
				id = Integer.parseInt(input.nextLine());
				System.out.print("Informe o nome: ");
				nome = input.nextLine();
				System.out.print("Informe o CPF: ");
				cpf = input.nextLine();
				System.out.print("Informe o endereço: ");
				endereco = input.nextLine();

				try {
					cliDAO.alterarCli(new Cliente(id, nome, cpf, endereco));
					System.out.println("Alterado com sucesso!\n");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 3:

				System.out.println("----------- Deletar cliente ---------\n\n");

				System.out.print("Indoforme o cpf do cliente: ");
				//id = Integer.parseInt(input.nextLine());
				cpf = input.nextLine();
				
				try {

					cliDAO.deletarCli(cpf);
					System.out.println("Deletado com sucesso!");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 4:

				System.out.println("Listar todos os clientes!");

				try {

					List<Cliente> clientes = cliDAO.listarClientes();

					for (Cliente client : clientes) {
						System.out.println(client.toString());
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 5:
				
				System.out.println("------------ Buscar Cliente pelo ID -----------");
				System.out.print("Informe o CPF do cliente: ");
				cpf = input.nextLine();
				
				try {
					
					System.out.println(cliDAO.buscarClienteCpf(cpf));
					
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:

				System.out.println("Cadastrar PET\n");
				System.out.print("Informe o nome do pet: ");
				nome = input.nextLine();
				System.out.print("Informe ocpf do dono: ");
				cpf = input.nextLine();
				System.out.print("Informe a idade do pet: ");
				idade = Integer.parseInt(input.nextLine());
				System.out.print("Informe a especie do pet: ");
				especie = input.nextLine();

				try {

					petDAO.cadastrarPet(new Pet(nome, cpf, idade, especie));
					System.out.println("Cadastrado com sucesso!");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 7:

				System.out.println("**********Atualiza pet********");

				System.out.print("Informe o ID do PET: ");
				id = Integer.parseInt(input.nextLine());
				System.out.print("Informe o nome do pet: ");
				nome = input.nextLine();
				System.out.print("Informe ocpf do dono: ");
				cpf = input.nextLine();
				System.out.print("Informe a idade do pet: ");
				idade = Integer.parseInt(input.nextLine());
				System.out.print("Informe a especie do pet: ");
				especie = input.nextLine();

				try {

					petDAO.atualizarPet(new Pet(id, nome, cpf, idade, especie));
					System.out.println("Atualizado com sucesso!");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 8:

				System.out.print("Informe o ID do PET: ");
				id = Integer.parseInt(input.nextLine());

				try {

					petDAO.deletarPet(id);
					System.out.println("Deletado com sucesso!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 9:

				System.out.println("-------Todos os Pets--------");

				try {

					List<Pet> pets = petDAO.listarPets();

					for (Pet petLista : pets) {
						System.out.println(petLista.toString());
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 10:
				
				System.out.println("--------- Buscar pet por id --------");
				
				System.out.print("Informe o id do pet: ");
				id = Integer.parseInt(input.nextLine());
				
				try {
					
					System.out.println(petDAO.buscarPetId(id));
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 11:

				System.out.println("------- Cadastrar Serviço ---------\n");
				System.out.println("Informe o nome do servico: ");
				nome = input.nextLine();
				System.out.println("Informe o preço: ");
				preco = Double.parseDouble(input.nextLine());

				try {

					servDAO.cadastrarServico(new Servico(nome, preco));
					System.out.println("Cadastrado com sucesso!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 12:

				System.out.println("------- Atualizar Serviço ---------\n");
				System.out.print("Informe o id do servico: ");
				id = Integer.parseInt(input.nextLine());
				System.out.print("Informe o nome do servico: ");
				nome = input.nextLine();
				System.out.print("Informe o preço: ");
				preco = Double.parseDouble(input.nextLine());

				try {
					servDAO.atualizarServico(new Servico(id,nome,preco));
					System.out.println("Alterado com sucesso!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 13:
				
				System.out.println("------ Deletar Serviço -------");
				
				System.out.print("Informe o id do serviço: ");
				id = Integer.parseInt(input.nextLine());
				
				try {
					
					servDAO.deletarServico(id);
					System.out.println("Deletado com sucesso!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 14:
				
				
				
				try {
					
					Servico servic = new Servico();
				
					List<Servico> servicos = servDAO.listarServicos(servic);
					
					for (Servico servico2 : servicos) {
						System.out.println(servico2.toString());
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 15:
				System.out.println("----------- Buscar servico por ID ----------");
				
				System.out.print("Informe o ID do serviço: ");
				id = Integer.parseInt(input.nextLine());
				
				try {
					
					System.out.println(servDAO.buscarServicoID(id));
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 16:
				
				System.out.println("---------- Alocar PET ao CLIENTE --------");
				
				System.out.print("Informe o CPF do cliente: ");
				cpf = input.nextLine();
				System.out.print("Informe o ID do PET: ");
				id = Integer.parseInt(input.nextLine());
				
				try {
					
					alocarDAO.alocarPetCliente(new AlocarPetCliente(cpf, id));
					System.out.println("Alocação concluida!");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 17: 
				
				System.out.println("------ Alterar Alocação ---------");
				
				System.out.print("Informe o CPF do cliente: ");
				cpf = input.nextLine();
				System.out.print("Informe o ID do PET: ");
				id = Integer.parseInt(input.nextLine());
				
				try {
					
					alocarDAO.atualizarAlocaPetCli(new AlocarPetCliente());
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 18:
				
				System.out.print("Informe o cpf do cliente: ");
				cpf = input.nextLine();
				
				try {
					
					alocarDAO.deletarAlocacao(cpf);
					System.out.println("Alocação deletada com sucesso!");
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 19:
				
				System.out.println("--------- Listar todas as alocações ------");
				
				try {
					
					List<AlocarPetCliente> alocacoes = alocarDAO.listarAlocacoes();
					
					for (AlocarPetCliente alocarPetCliente : alocacoes) {
						System.out.println(alocarPetCliente.toString());
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 20:
				
				System.out.println("--------- Buscar alocacao pelo CPF ---------");
				
				System.out.print("Informe o cpf: ");
				cpf = input.nextLine();
				
				try {
					
					System.out.println(alocarDAO.buscarAlocacaoCPF(cpf));
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 21:
				
				System.out.println("----------- Cadastrar Venda -------------");
				
				System.out.println("Informe o cpf: ");
				cpf = input.nextLine();
				System.out.println("Informe o id do PET: ");
				id = Integer.parseInt(input.nextLine());
				System.out.println("Informe o id do serviço: ");
				int idServ = Integer.parseInt(input.nextLine());
				
				try {
					
					vendaDAO.cadastrarVenda(new Venda(cpf,id,idServ));
					System.out.println("Venda Cadastrada!");
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 22:
				
				System.out.println("------------- Valor do cliente ---------");
				
				System.out.print("Informe o cpf do cidadão: ");
				cpf = input.nextLine();
				
				try {
					
					vendaDAO.valorDaCompra(cpf);
					System.out.println("Blzz");
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 23:
				
				System.out.println("--------- Listar Vendas -------");
				
				try {
					
					List<Venda> vendas = vendaDAO.listarVendas();
					
					for (Venda venda2 : vendas) {
						System.out.println(venda2.toString());
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 24:
				
				System.out.println("-------- Deletar Venda ---------");
				
				System.out.print("Informe o ID da venda: ");
				id = Integer.parseInt(input.nextLine());
				
				try {
					
					vendaDAO.deletar(id);
					System.out.println("Venda deletada com sucesso!");
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 25:
				
				System.out.println("------ Buscar venda por id --------");
				
				System.out.print("Informe o ID da venda: ");
				id = Integer.parseInt(input.nextLine());
				
				try {
					
					System.out.println(vendaDAO.buscar(id));
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 55:
				sair = true;
				System.out.println("Bye");
				break;
				
			default:
				System.out.println("Opção indisponível!");
				break;
			}

		}

	}

}
