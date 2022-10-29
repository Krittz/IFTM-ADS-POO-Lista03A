package model;

public class Caminhao extends Veiculo {

	private float capacidadeDeCarga;
	
	public Caminhao() {
		super();
	}

	public Caminhao(String marca, String modelo, int anoFabricacao, int anoModelo, double preco,
			float capacidadeDeCarga) {
		super(marca, modelo, anoFabricacao, anoModelo, preco);
		this.capacidadeDeCarga = capacidadeDeCarga;
	}

	public float getCapacidadeDeCarga() {
		return capacidadeDeCarga;
	}

	public void setCapacidadeDeCarga(float capacidadeDeCarga) {
		this.capacidadeDeCarga = capacidadeDeCarga;
	}
}
