package main;

import java.util.Scanner;

public class App {
	public static Locadora locadora = new Locadora();
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String continuar = "s";
		int opcao = -1;
		do {
			System.out.println("Locadora");
			System.out.println("[0] - Cadastrar um carro");
			System.out.println("[1] - Cadastrar uma moto");
			System.out.println("[2] - Alugar um carro");
			System.out.println("[3] - Alugar uma moto");
			System.out.println("[4] - Listar os veiculos disponiveis");
			do {
				System.out.print("Sua escolha: ");
				opcao = scan.nextInt();
				if(opcao < 0 || opcao > 4) {
					System.out.println("Opção invalida");
				}
			} while (opcao < 0 || opcao > 4);
			switch (opcao) {
			case 0:
				cadastrarVeiculo(0);
				break;
			case 1:
				cadastrarVeiculo(1);
				break;
			case 2:
				alugarVeiculo(0);
				break;
			case 3:
				alugarVeiculo(1);
				break;
			case 4:
				locadora.listarVeiculos();
				break;
		}
		System.out.println("Deseja realizar mais alguma operacao? (s/n)");
		do {
			System.out.print("Sua escolha: ");
			continuar = scan.next().toLowerCase();
			if(!(continuar.equals("s")  || continuar.equals("n"))) {
				System.out.println("Opção invalida");
			}
		} while(!(continuar.equals("s")  || continuar.equals("n")));
		System.out.println();
		} while(continuar.equals("s"));
	}
	
	public static void cadastrarVeiculo(int tipoVeiculo) {
		String marca = "";
		String modelo = "";
		int ano = 0;
		double precoDia = 0.0;
		
		System.out.println("Qual a marca?");
		marca = scan.next().toLowerCase();
		
		System.out.println("Qual o modelo?");
		modelo = scan.next().toLowerCase();
		
		System.out.println("Qual o ano?");
		ano = scan.nextInt();
		
		System.out.println("Qual o preco por dia");
		precoDia = scan.nextDouble();
		
		if(tipoVeiculo == 0) {
			int numPortas = 2;
			System.out.println("Ele é de 2 ou 4 portas?");
			do {
				numPortas = scan.nextInt();
				if(!(numPortas == 2 || numPortas == 4)) {
					System.out.println("Opcao invalida, digite novamente");
				}
			} while(!(numPortas == 2 || numPortas == 4));
			
			Carro carro = new Carro(marca, modelo, ano, precoDia, numPortas);
			locadora.adicionarVeiculo(carro);
		} else {
			String bagageiro = "";
			System.out.println("Ela possui bagageiro? (s/n)");
			do {
				bagageiro = scan.next();
				if(!(bagageiro.equals("s") || bagageiro.equals("n"))) {
					System.out.println("Opcao invalida, digite novamente");
				}
			} while(!(bagageiro.equals("s") || bagageiro.equals("n")));
			
			Moto moto = new Moto(marca, modelo, ano, precoDia, bagageiro == "s");
			locadora.adicionarVeiculo(moto);
		}
		
	}
	public static void alugarVeiculo(int tipoVeiculo) {
		
		String modelo = "";
		int dias = 0;
		
		System.out.println("Qual o modelo do veiculo?");
		modelo = scan.next().toLowerCase();
		
		System.out.println("Por quantos dias?");
		do {
			dias = scan.nextInt();
			if(dias < 1) {
				System.out.println("Opcao invalida, digite novamente: ");
			}
		} while (dias < 1);
		
		if(tipoVeiculo == 0) {
			locadora.alugarVeiculo(new Carro(null, modelo, 0, 0.0, 0), dias);
		} else {
			locadora.alugarVeiculo(new Moto(null, modelo, 0, 0.0, false), dias);
		}
	}
}
