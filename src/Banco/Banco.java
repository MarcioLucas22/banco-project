package Banco;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Banco {

	private static Scanner teclado = new Scanner(System.in);
	private static ArrayList<Conta> contas = new ArrayList<Conta>();

	public static void main(String[] args) {
		Banco.contas = new ArrayList<Conta>();
		Banco.menu();
	}

	public static void menu() {
		System.out.println("Escolha uma das opções abaixo");
		System.out.println("1 - Criar conta");
		System.out.println("2 - Efetuar saque");
		System.out.println("3 - Efetuar depósito");
		System.out.println("4 - Fazer transferência");
		System.out.println("5 - Listar contas");
		System.out.println("6 - Sair do programa");

		int op = 0;

		try {
			op = Integer.parseInt(Banco.teclado.nextLine());
		} catch (NumberFormatException f) {
			System.out.println("Informe uma opção válida.");
			Utils.pausar(1);
			Banco.menu();
		}

		switch (op) {
		case 1:
			Banco.criarConta();
			break;

		case 2:
			Banco.efetuarSaque();
			break;

		case 3:
			Banco.efetuarDeposito();
			break;

		case 4:
			Banco.efetuarTransferencia();
			break;

		case 5:
			Banco.listarContas();
			break;

		case 6:
			System.out.println("Até a próxima!");
			Utils.pausar(2);
			System.exit(0);

		default:
			System.out.println("Informe uma opção válida.\n");
			Utils.pausar(2);
			Banco.menu();
			break;
		}
	}

	public static void criarConta() {
		System.out.println("Informe seu nome:");
		String nome = Banco.teclado.nextLine();

		System.out.println("Informe seu CPF: ");
		String cpf = Banco.teclado.nextLine();

		System.out.println("Informe seu E-mail: ");
		String email = Banco.teclado.nextLine();

		Cliente cliente1 = new Cliente(nome, cpf, email);
		Conta conta = new Conta(cliente1);
		Banco.contas.add(conta);
		System.out.println("Conta criada com sucesso!\n");
		System.out.println(conta + "\n");
		Utils.pausar(3);
		Banco.menu();
	}

	public static void efetuarSaque() {
		System.out.println("Informe o número da conta: ");
		int numero_conta = Banco.teclado.nextInt();

		Conta conta = Banco.buscarContaPorNumero(numero_conta);

		if (conta != null) {
			System.out.println("Informe o valor para saque:");
			double valor = Banco.teclado.nextDouble();
			conta.sacar(valor);
		} else {
			System.out.println("Erro: Informe uma conta válida.");
		}

		Utils.pausar(3);
		Banco.menu();
	}

	public static Conta buscarContaPorNumero(int numero_conta) {
		Conta c = null;
		if(Banco.contas.size() > 0) {
			for (Conta conta : Banco.contas) {
				if (conta.getNumero_conta() == numero_conta) {
					 c = conta;
				} else {
					System.out.println("Conta inexistente.");
				}
			}
		} else {
			System.out.println("Ainda não existe contas cadastradas.");
		} 
		
		return c;
	}

	public static void efetuarDeposito() {
		System.out.println("Informe o número da conta para depósito:");
		int numero_conta = Banco.teclado.nextInt();

		Conta conta = Banco.buscarContaPorNumero(numero_conta);

		if (conta != null) {
			System.out.println("Informe o valor do depósito:");
			double valor = Banco.teclado.nextDouble();
			conta.depositar(valor);
		} else {
			System.out.println("Erro: Informe uma conta válida.");
		}
		
		Utils.pausar(3);
		Banco.menu();
	}

	public static void efetuarTransferencia() {
		System.out.println("Informe o número da sua conta:");
		int numero_conta = Banco.teclado.nextInt();

		Conta conta = Banco.buscarContaPorNumero(numero_conta);

		if (conta != null) {
			System.out.println("Informe o número da conta destino:");
			int conta_destino = Banco.teclado.nextInt();
			Conta conta_d = Banco.buscarContaPorNumero(numero_conta);

			if (conta_d != null) {
				System.out.println("Informe o valor da transfência:");
				double valor = Banco.teclado.nextDouble();
				conta.tranferir(conta_d, valor);
			} else {
				System.out.println("Erro: Informe uma conta válida.");
			}

		} else {
			System.out.println("Erro: Informe uma conta válida.");
		}

		Utils.pausar(3);
		Banco.menu();
	}

	public static void listarContas() {

		if (Banco.contas.size() > 0) {
			for (Conta conta : Banco.contas) {
				System.out.println("\n" + conta + "\n");
			}
		} else {
			System.out.println("Ainda não existe contas cadastradas.");
		}
		
		Utils.pausar(3);
		Banco.menu();
	}
}
