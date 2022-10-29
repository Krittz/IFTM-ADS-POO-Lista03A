package gerencia;

import java.util.ArrayList;
import java.util.Scanner;

import model.Cliente;

public class GerenciaCliente {

	private Scanner sc;
	private ArrayList<Cliente> clientes;

	public GerenciaCliente(ArrayList<Cliente> clientes) {
		this.sc = new Scanner(System.in);
		this.clientes = clientes;
	}

	public void incluir() {

		System.out.println("====================================");
		System.out.println("...::: Incluir Cliente :::...");
		System.out.println("====================================");

		Cliente cliente = new Cliente();

		lerDados(cliente);
		clientes.add(cliente);

		System.out.println("Cliente cadastrado com sucesso!");

	}

	public void alterar() {

		System.out.println("====================================");
		System.out.println("...::: Alterar Cliente :::...");
		System.out.println("====================================");

		if (clientes.isEmpty()) {
			System.out.println("...::: AVISO :::...");
			System.out.println("Não há clientes cadastrados!");
			System.out.println("....................................");
		} else {
			System.out.println("Digite a Posição do cliente para alterar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");

			String mensagem = "O cliente que deseja alterar é este?";

			if (validarDados(pos, mensagem)) {
				System.out.println("Digite os novos dados: ");
				lerDados(clientes.get(pos));
				System.out.println("Cliente alterado com sucesso!");
				System.out.println("....................................");
			}
		}
	}

	public void remover() {
		System.out.println("====================================");
		System.out.println("...::: Excluir Cliente :::...");
		System.out.println("====================================");

		if (clientes.isEmpty()) {
			System.out.println("...::: AVISO :::...");
			System.out.println("Não há clientes cadastrados!");
			System.out.println("....................................");
		} else {
			System.out.println("Digite a Posição do cliente para remover: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");

			String mensagem = "O cliente que deseja remover é este?";

			if (validarDados(pos, mensagem)) {
				clientes.remove(pos);
				System.out.println("Cliente excluído com sucesso!");
				System.out.println("....................................");
			}
		}
	}

	public void consultar() {
		System.out.println("====================================");
		System.out.println("...::: Consultar Cliente :::...");
		System.out.println("====================================");

		if (clientes.isEmpty()) {
			System.out.println("...::: AVISO :::...");
			System.out.println("Não há clientes cadastrados!");
			System.out.println("....................................");
		} else {
			System.out.println("Digite a Posição do cliente para consultar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");

			String mensagem = "O cliente que deseja consultar é este?";

			if (!validarDados(pos, mensagem)) {
				consultar();
			}
		}
	}

	public void relatorio() {
		System.out.println("====================================");
		System.out.println("...::: Listar Clientes :::...");
		System.out.println("====================================");

		if (clientes.isEmpty()) {
			System.out.println("...::: AVISO :::...");
			System.out.println("Não há clientes cadastrados!");
			System.out.println("....................................");
		} else {
			for (Cliente cliente : clientes) {
				System.out.println("-------------------------------");
				System.out.println("Posição #" + clientes.indexOf(cliente));
				imprimir(cliente);
			}
			System.out.println("-------------------------------");
		}
	}

	private void lerDados(Cliente cliente) {

		System.out.println("1. Digite o nome do cliente: ");
		cliente.setNome(sc.nextLine());

		System.out.println("2. Digite o telefone do cliente: ");
		cliente.setTelefone(sc.nextLine());

		System.out.println("3. Digite o CPF do cliente: ");
		cliente.setCpf(sc.nextLine());

	}

	private void imprimir(Cliente cliente) {
		System.out.println("...............................");
		System.out.println("Nome      = " + cliente.getNome());
		System.out.println("Telefone  = " + cliente.getTelefone());
		System.out.println("CPF       = " + cliente.getCpf());
		System.out.println("...............................");
	}

	private boolean validarDados(int pos, String mensagem) {

		if (pos < 0 || pos >= clientes.size()) {
			System.out.println("ALERTA: Posição inválida. Deve ser um Número entre 0 e N-1");
			return false;
		}

		System.out.println(mensagem);
		imprimir(clientes.get(pos));

		System.out.println("[1] Sim");
		System.out.println("[2] Não");

		int opcao = Integer.parseInt(sc.nextLine());

		if (opcao != 1) {
			System.out.println("Voltando ao menu inicial...");
			return false;
		}
		return true;
	}
}