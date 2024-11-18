package main;

import java.util.ArrayList;

public class Locadora {
	private double lucro;
	private ArrayList<? super Veiculo> veiculos = new ArrayList<>();
	
	public <T extends Veiculo> void adicionarVeiculo(T v) {
		this.veiculos.add(v);
	}	
	
	public <T extends Veiculo> void alugarVeiculo(T veiculo, int dias) {
		@SuppressWarnings("unchecked")
		
		ArrayList<? extends Veiculo> listVeiculos = (ArrayList<? extends Veiculo>) this.veiculos.clone();
		
		double antigoLucro = this.lucro;
		String nameClass = veiculo.getClass().getName();
		
		listVeiculos.forEach(v -> {
			if(v.getClass() == veiculo.getClass() && v.getModelo() == veiculo.getModelo()) {
				this.lucro += v.calcularAluguel(dias);
				this.veiculos.remove(v);
				System.out.println(String.format("%s vendido(a)", nameClass.substring(5, nameClass.length())));
				return;
			}
		});
		if(antigoLucro == this.lucro) {
			System.out.println(String.format("%s fora de estoque", nameClass.substring(5, nameClass.length())));
		}
		
	}
	
	public void listarVeiculos() {
		if(this.veiculos.isEmpty()) {
			System.out.println("Sem veiculos disponiveis");
			return;
		}
		this.veiculos.forEach(veiculo -> {
			System.out.println(veiculo.toString());
		});
	}
	
	public double getLucro() {
		return lucro;
	}
	public void setLucro(double lucro) {
		this.lucro = lucro;
	}
	
}
