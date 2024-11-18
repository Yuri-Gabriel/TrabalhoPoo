package main;

public abstract class Veiculo {
	protected String marca;
	protected int ano;
	protected double precoDia;
	protected String modelo;
	
	public Veiculo(String marca, String modelo, int ano, double precoDia) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.precoDia = precoDia;
	}
	
	public abstract double calcularAluguel(int dias);
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getPrecoDia() {
		return precoDia;
	}

	public void setPrecoDia(double precoDia) {
		this.precoDia = precoDia;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return String.format("marca: %s | modelo: %s | ano: %d | preco por dia: %.2f", this.getMarca(), this.getModelo(), this.getAno(), this.getPrecoDia());
	}
}
