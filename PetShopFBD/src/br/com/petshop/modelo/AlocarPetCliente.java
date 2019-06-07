package br.com.petshop.modelo;

public class AlocarPetCliente {

	private String cpfCliente;
	private int idPet;
	
	public AlocarPetCliente() {
		
	}

	public AlocarPetCliente(String cpfCliente, int idPet) {
		super();
		this.cpfCliente = cpfCliente;
		this.idPet = idPet;
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

	@Override
	public String toString() {
		return "AlocarPetCliente [cpfCliente=" + cpfCliente + ", idPet=" + idPet + "]";
	}
	
	
	
}
