package main;

import java.util.ArrayList;

public class Locadora {
	private double lucro;
	private ArrayList<Carro> carros = new ArrayList<>();
	private ArrayList<Moto> motos = new ArrayList<>();
	/*
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
	*/
	public void listarCarros() {
		if(this.carros.isEmpty()) {
			System.out.println("Sem carros disponiveis");
			return;
		}
		this.carros.forEach(carro -> {
			System.out.println(carro.toString());
		});
	}
	public void listarMotos() {
		if(this.motos.isEmpty()) {
			System.out.println("Sem motos disponiveis");
			return;
		}
		this.motos.forEach(moto -> {
			System.out.println(moto.toString());
		});
	}
	
	public void adicionarVeiculo(Carro c) {
		this.carros.add(c);
	}
	public void adicionarVeiculo(Moto m) {
		this.motos.add(m);
	}
	
	public void alugarVeiculo(Carro c, int dias) {
		ArrayList<Carro> listaCarros = (ArrayList<Carro>) this.carros.clone();
		if(!this.carros.isEmpty()) {
			double antigoLucro = this.lucro;
			listaCarros.forEach(carro -> {
				if(carro.getModelo() == c.getModelo()) {
					this.lucro += carro.calcularAluguel(dias);
					this.carros.remove(carro);
				}
			});
			if(antigoLucro < this.lucro) {
				System.out.println("Carro alugado");
			} else {
				System.out.println("O carro solicitado esta fora de estoque");
			}
		} else {
			System.out.println("Sem carros disponiveis");
		}
		
	}
	
	public void alugarVeiculo(Moto m, int dias) {
		ArrayList<Moto> listaMotos = (ArrayList<Moto>) this.motos.clone();
		if(!this.motos.isEmpty()) {
			double antigoLucro = this.lucro;
			listaMotos.forEach(moto -> {
				if(moto.getModelo() == m.getModelo()) {
					this.lucro += moto.calcularAluguel(dias);
					this.motos.remove(moto);
				}
			});
			if(antigoLucro < this.lucro) {
				System.out.println("Moto alugada");
			} else {
				System.out.println("A moto solicitada esta fora de estoque");
			}
		} else {
			System.out.println("Sem motos disponiveis");
		}
		
	}
	
	public double getLucro() {
		return lucro;
	}
	public void setLucro(double lucro) {
		this.lucro = lucro;
	}
	public ArrayList<Carro> getCarros() {
		return carros;
	}
	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}
	public ArrayList<Moto> getMotos() {
		return motos;
	}
	public void setMotos(ArrayList<Moto> motos) {
		this.motos = motos;
	}
	
}
