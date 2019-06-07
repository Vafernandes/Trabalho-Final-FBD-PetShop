package br.com.petshop.modelo;

public class Pet {

	private int id;
	private String nome;
	private String cpfDono;
	private int idade;
	private String especie;
	
	public Pet() {
		
	}

	public Pet(int id, String nome, String cpfDono, int idade, String especie) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpfDono = cpfDono;
		this.idade = idade;
		this.especie = especie;
	}

	public Pet(String nome, String cpfDono, int idade, String especie) {
		super();
		this.nome = nome;
		this.cpfDono = cpfDono;
		this.idade = idade;
		this.especie = especie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfDono() {
		return cpfDono;
	}

	public void setCpfDono(String cpfDono) {
		this.cpfDono = cpfDono;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", nome=" + nome + ", cpfDono=" + cpfDono + ", idade=" + idade + ", especie=" + especie
				+ "]";
	}
	
	
	
}
