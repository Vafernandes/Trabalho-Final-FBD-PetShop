package br.com.petshop.modelo;

public class Venda {

	private int id;
	private String cpfCliente;
	private int idPet;
	private int idServico;
	
	public Venda() {
		
	}
	
	public Venda(int id, String cpfCliente, int idPet, int idServico) {
		super();
		this.id = id;
		this.cpfCliente = cpfCliente;
		this.idPet = idPet;
		this.idServico = idServico;
	}

	public Venda(String cpfCliente, int idPet, int idServico) {
		super();
		this.cpfCliente = cpfCliente;
		this.idPet = idPet;
		this.idServico = idServico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public int getIdPet() {
		return idPet;
	}

	public void setIdPet(int idPet) {
		this.idPet = idPet;
	}

	public int getIdServico() {
		return idServico;
	}

	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", cpfCliente=" + cpfCliente + ", idPet=" + idPet + ", idServico=" + idServico + "]";
	}

	
	
	
}
