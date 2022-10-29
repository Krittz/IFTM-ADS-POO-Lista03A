package gerencia;

import java.util.ArrayList;
import java.util.Scanner;

import model.Caminhao;

public class GerenciaCaminhao {

	private Scanner sc;
	private ArrayList<Caminhao> caminhoes;

	public GerenciaCaminhao(ArrayList<Caminhao> caminhoes) {
		this.sc = new Scanner(System.in);
		this.caminhoes = caminhoes;
	}

//====================================================================================================
	public void incluir() {

		System.out.println("====================================");
		System.out.println("...::: Incluir Caminhão :::...");
		System.out.println("====================================");

		Caminhao caminhao = new Caminhao();

		lerDados(caminhao);
		caminhoes.add(caminhao);

		System.out.println("Caminhão cadastrado com sucesso!");
		System.out.println("....................................");

	}

	//====================================================================================================
	public void alterar() {

		System.out.println("====================================");
		System.out.println("...::: Alterar Caminhão :::...");
		System.out.println("====================================");

		if (caminhoes.isEmpty()) {
			System.out.println("...::: AVISO :::...");
			System.out.println("Não há caminhões cadastrados!");
			System.out.println("....................................");
		} else {
			System.out.println("Digite a posição do caminhão para alterar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");

			String mensagem = "O caminhão que deseja alterar é este?";

			if (validarDados(pos, mensagem)) {
				System.out.println("Digite os novos dados: ");
				lerDados(caminhoes.get(pos));
				System.out.println("Caminhão alterado com sucesso!");
				System.out.println("....................................");
			}
		}
	}

	//====================================================================================================
	public void remover() {
		System.out.println("====================================");
		System.out.println("...::: Excluir Caminhão :::...");
		System.out.println("====================================");

		if (caminhoes.isEmpty()) {
			System.out.println("...::: AVISO :::...");
			System.out.println("Não há caminhões cadastrados!");
			System.out.println("....................................");
		} else {
			System.out.println("Digite a posição do caminhão para remover: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");

			String mensagem = "O caminhão que deseja remover é este?";

			if (validarDados(pos, mensagem)) {
				caminhoes.remove(pos);
				System.out.println("Caminhão excluído com sucesso!");
				System.out.println("....................................");
			}
		}
	}
//====================================================================================================
	public void consultar() {
		System.out.println("====================================");
		System.out.println("...::: Consultar Caminhão :::...");
		System.out.println("====================================");

		if (caminhoes.isEmpty()) {
			System.out.println("...::: AVISO :::...");
			System.out.println("Não há caminhões cadastrados!");
			System.out.println("....................................");
		} else {
			System.out.println("Digite a posição do caminhão para consultar: ");
			int pos = sc.nextInt();
			sc.skip("\r\n");

			String mensagem = "O caminhão que deseja consultar é este?";

			if (!validarDados(pos, mensagem)) {
				consultar();
			}
		}
	}


	public void relatorio() {
		System.out.println("====================================");
		System.out.println("...::: Listar Caminhões :::...");
		System.out.println("====================================");

		if (caminhoes.isEmpty()) {
			System.out.println("AVISO: Não há caminhões cadastrados!");
		} else {
			for (Caminhao caminhao : caminhoes) {
				System.out.println("-------------------------------");
				System.out.println("posição #" + caminhoes.indexOf(caminhao));
				imprimir(caminhao);
			}
			System.out.println("-------------------------------");
		}
	}

	//====================================================================================================
	private void lerDados(Caminhao caminhao) {

		System.out.println("1. Digite a marca do caminhão: ");
		caminhao.setMarca(sc.nextLine());

		System.out.println("2. Digite o modelo do caminhão: ");
		caminhao.setModelo(sc.nextLine());

		System.out.println("3. Digite o ano de fabricação do caminhão: ");
		caminhao.setAnoFabricacao(sc.nextInt());
		sc.skip("\r\n");

		System.out.println("4. Digite o ano de modelo do caminhão: ");
		caminhao.setAnoModelo(sc.nextInt());
		sc.skip("\r\n");

		System.out.println("5. Digite o preço do caminhão: ");
		caminhao.setPreco(sc.nextDouble());
		sc.skip("\r\n");

		System.out.println("6. Digite a capacidade de carga do caminhão: ");
		caminhao.setCapacidadeDeCarga(sc.nextFloat());
		sc.skip("\r\n");

	}

	//====================================================================================================
	private void imprimir(Caminhao caminhao) {
		System.out.println("....................................");
		System.out.println("Marca                = " + caminhao.getMarca());
		System.out.println("Modelo               = " + caminhao.getModelo());
		System.out.println("Ano de fabricação    = " + caminhao.getAnoFabricacao());
		System.out.println("Ano de Modelo        = " + caminhao.getAnoModelo());
		System.out.printf("preço                = R$ %.2f\n", caminhao.getPreco());
		System.out.println("Capacidade carga     = " + caminhao.getCapacidadeDeCarga());
		System.out.println("....................................");
	}

	//====================================================================================================
	private boolean validarDados(int pos, String mensagem) {

		if (pos < 0 || pos >= caminhoes.size()) {
			System.out.println("ALERTA: posição inválida. Deve ser um número entre 0 e N-1");
			return false;
		}

		System.out.println(mensagem);
		imprimir(caminhoes.get(pos));

		System.out.println("[1] Sim");
		System.out.println("[2] Não");

		int opcao = sc.nextInt();
		sc.skip("\r\n");

		if (opcao != 1) {
			System.out.println("Voltando ao menu inicial...");
			return false;
		}
		return true;
	}
}