package model;

public class Onibus extends Veiculo {
	
	private int quantidadePassageiros;
	private int quantidadeEixos;
	
	public Onibus() {
		super();
	}

	public Onibus(String marca, String modelo, int anoFabricacao, int anoModelo, double preco,
			int quantidadePassageiros, int quantidadeEixos) {
		super(marca, modelo, anoFabricacao, anoModelo, preco);
		this.quantidadePassageiros = quantidadePassageiros;
		this.quantidadeEixos = quantidadeEixos;
	}

	public int getQuantidadePassageiros() {
		return quantidadePassageiros;
	}

	public void setQuantidadePassageiros(int quantidadePassageiros) {
		this.quantidadePassageiros = quantidadePassageiros;
	}

	public int getQuantidadeEixos() {
		return quantidadeEixos;
	}

	public void setQuantidadeEixos(int quantidadeEixos) {
		this.quantidadeEixos = quantidadeEixos;
	}
}
