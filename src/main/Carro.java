package main;

public class Carro extends Veiculo {
	
	private int numPortas;

	public Carro(String marca, String modelo, int ano, double precoDia, int numPortas) {
		super(marca, modelo, ano, precoDia);
		this.numPortas = numPortas;
	}

	@Override
	public double calcularAluguel(int dias) {
		double extra = this.numPortas == 2 ? 0 : 50;
		return (this.getPrecoDia() + extra) * dias;
	}

	public int getNumPortas() {
		return numPortas;
	}

	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + " | numero de portas: %d", this.getNumPortas());
	}

}
