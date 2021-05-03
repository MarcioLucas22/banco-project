package Banco;

public class Conta {
	private static int contador = 1001;
	private int numero_conta;
	private Cliente cliente;
	private double saldo = 0.0;

	public Conta(Cliente cliente) {
		this.numero_conta = Conta.contador;
		this.cliente = cliente;
		Conta.contador++;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Conta.contador = contador;
	}

	public int getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(int numer_conta) {
		this.numero_conta = numer_conta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return "Cliente - " + this.getCliente() + "\nNúmero da conta: " + this.getNumero_conta() + "\nSaldo: "
				+ Utils.doubleParaString(this.getSaldo());
	}

	public void depositar(double valor) {
		if (valor > 0) {
			this.saldo = this.getSaldo() + valor;
			System.out.println("Depósito efetuado com sucesso!");
			System.out.println("Saldo atual: " + this.getSaldo());
		} else {
			System.out.println("Não foi possível efetuar o depósito");
		}
	}

	public void sacar(double valor) {
		if (valor > 0 && this.saldo >= valor) {
			this.saldo = this.getSaldo() - valor;
			System.out.println("Saque efetuado com sucesso!");
			System.out.println("Saldo atual: " + this.getSaldo());
		} else {
			System.out.println("Não foi possível efetuar o saque");
		}
	}
	
	public void tranferir(Conta conta_destino, double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			this.saldo = this.getSaldo() - valor;
			conta_destino.saldo = this.getSaldo() + valor;
			System.out.println("Transferência efetuada com sucesso!");
			System.out.println("Saldo atual: " + this.getSaldo());
		} else {
			System.out.println("Não foi possível efetuar a transferência");
		}
	}

}
