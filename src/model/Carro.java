package model;

public class Carro extends Veiculo{
	
	private int quantidadePortas;
	
	public Carro() {
		super();
	}
	
	public Carro(String marca, String modelo, int anoFabricacao, int anoModelo, double preco, int quantidadePortas) {
		super(marca, modelo, anoFabricacao, anoModelo, preco);
		this.quantidadePortas = quantidadePortas;
	}

	public int getQuantidadePortas() {
		return quantidadePortas;
	}

	public void setQuantidadePortas(int quantidadePortas) {
		this.quantidadePortas = quantidadePortas;
	}	
}
