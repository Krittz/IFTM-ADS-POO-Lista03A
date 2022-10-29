package model;

import java.time.LocalDate;

public class Venda {
	private Veiculo veiculo;
	private Cliente cliente;
	private LocalDate data;
	private double preco;
	
	public Venda() {}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco() {
		this.preco = this.veiculo.getPreco();
	}
	
}
