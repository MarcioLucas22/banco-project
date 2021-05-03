package Banco;

public class Cliente {
	private static int contador = 101;
	private int codigo_cliente;
	private String nome;
	private String email;
	private String cpf;
	
	public Cliente(String nome, String email, String cpf) {
		this.codigo_cliente = Cliente.contador;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		Cliente.contador++;
	}
	
	public int getCodigo_cliente() {
		return codigo_cliente;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}
	
	public String toString() {
		return "Nome: " + this.getNome() +
				"\nE-mail: " + this.getEmail() + 
				"\nCPF: " + this.getCpf() + 
				"\nCódigo cliente: " + this.getCodigo_cliente();
	}
}
