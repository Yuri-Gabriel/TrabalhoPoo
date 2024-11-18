package main;

public class Moto extends Veiculo {
	
	private boolean possuiBagageiro;

	public Moto(String marca, String modelo, int ano, double precoDia, boolean possuiBagageiro) {
		super(marca, modelo, ano, precoDia);
		this.possuiBagageiro = possuiBagageiro;
	}

	@Override
	public double calcularAluguel(int dias) {
		double extra = this.possuiBagageiro ? 50 : 0;
		return (this.getPrecoDia() + extra) * dias;
	}

	public boolean isPossuiBagageiro() {
		return possuiBagageiro;
	}

	public void setPossuiBagageiro(boolean possuiBagageiro) {
		this.possuiBagageiro = possuiBagageiro;
	}
	
	@Override
	public String toString() {
		return String.format(super.toString() + " | tem bagageiro: %s", this.isPossuiBagageiro() ? "sim" : "nao");
	}

}
