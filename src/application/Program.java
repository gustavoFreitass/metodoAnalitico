package application;

import java.util.Scanner;

import entities.Produto1;
import entities.Produto2;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int restricao1, restricao2, quantidadeDeMateriaPrimaGastosProduto1, quantidadeDeTempoGastosProduto1, quantidadeDeMateriaPrimaGastosProduto2, quantidadeDeTempoGastosProduto2;
		double valorProduto;
		String produtoInserido1, produtoInserido2;
		
		//Produto 1
		System.out.print("Seja bem-vindo! Digite o nome do produto: ");
		produtoInserido1 = sc.nextLine();
		System.out.print("\nDigite a quantidade de matéria prima que o(a) " + produtoInserido1 + " gasta para ser produzido: ");
		quantidadeDeMateriaPrimaGastosProduto1 = sc.nextInt();
		System.out.print("Digite a quantidade de tempo que o(a) " + produtoInserido1 + " gasta para ser produzido: ");
		quantidadeDeTempoGastosProduto1 = sc.nextInt();
		System.out.print("Digite o lucro que possui com o(a) " + produtoInserido1 + ": ");
		valorProduto = sc.nextDouble();
		Produto1 p1 = new Produto1(quantidadeDeMateriaPrimaGastosProduto1, quantidadeDeTempoGastosProduto1, valorProduto);
		
		
		//Produto 2
		System.out.print("\nDigite o nome do segundo produto: ");
		sc.nextLine();
		produtoInserido2 = sc.nextLine();
		System.out.print("\nDigite a quantidade de matéria prima que o(a) " + produtoInserido2 + " gasta para ser produzido: ");
		quantidadeDeMateriaPrimaGastosProduto2 = sc.nextInt();
		System.out.print("Digite a quantidade de tempo que o(a) " + produtoInserido2 + " gasta para ser produzido: ");
		quantidadeDeTempoGastosProduto2 = sc.nextInt();
		System.out.print("Digite o lucro que possui com o(a) " + produtoInserido2 + ": ");
		valorProduto = sc.nextDouble();
		Produto2 p2 = new Produto2(quantidadeDeMateriaPrimaGastosProduto2, quantidadeDeTempoGastosProduto2, valorProduto);
		
		//restrições
		System.out.print("\nDigite a quantidade de matéria prima disponível: ");
		restricao1 = sc.nextInt();
		System.out.print("Digite a quantidade de tempo disponível: ");
		restricao2 = sc.nextInt();
		
		//Inciando a Primeira Comparação
		double qtdCenario1Produto1 = p1.getPrimeiraComparacao(restricao1, restricao2, p2);
		p2.setProduto1(qtdCenario1Produto1);
		double qtdCenario1Produto2 = p2.getPrimeiraComparacao(restricao1, restricao2, p1);
		
		double lucroCenario1 = p1.getLucroTotal() * qtdCenario1Produto2 + p2.getLucroTotal() * qtdCenario1Produto1;
		
		System.out.println("\nComparação I e II: ");
		if(qtdCenario1Produto2 * quantidadeDeMateriaPrimaGastosProduto1 + qtdCenario1Produto1 * quantidadeDeMateriaPrimaGastosProduto2 <= restricao1) {
			if(qtdCenario1Produto2 * quantidadeDeTempoGastosProduto1 + qtdCenario1Produto1 * quantidadeDeTempoGastosProduto2 <= restricao2) {
				if(qtdCenario1Produto1 >= 0) {
					if(qtdCenario1Produto2 >= 0) {
						System.out.println("\nQuantidade de " + produtoInserido1 + " a ser produzido(a) no cenário 1: " + qtdCenario1Produto2);
						System.out.println("Quantidade de " + produtoInserido2 + " a ser produzido(a) no cenário 1: " + qtdCenario1Produto1);
						System.out.printf("Lucro obtido nesse primeiro cenário: R$%.2f\n", lucroCenario1);
					}
					else {
						System.out.println("\nSolução inviável!");
					}
				}
				else {
					System.out.println("\nSolução inviável!");
				}
			}
			else {
				System.out.println("\nSolução inviável!");
			}
		
		}
		else {
			System.out.println("\nSolução inviável!");
		}
		
		//Iniciando a Segunda Comparação
		System.out.println("\nComparação I e III: ");
		double qtdCenario2Produto1 = p1.getSegundaComparacao(0, p2);
		p2.setProduto1(qtdCenario2Produto1);
		double qtdCenario2Produto2 = restricao1 / quantidadeDeMateriaPrimaGastosProduto2;
		double lucroCenario2 = p1.getLucroTotal() * qtdCenario2Produto1 + p2.getLucroTotal() * qtdCenario2Produto2;
		
		if(quantidadeDeMateriaPrimaGastosProduto1 * qtdCenario2Produto2 + quantidadeDeMateriaPrimaGastosProduto2 * qtdCenario2Produto1 <= restricao1) {
			if(quantidadeDeTempoGastosProduto1 * qtdCenario2Produto2 + quantidadeDeTempoGastosProduto2 * qtdCenario2Produto1 <= restricao2) {
				if(qtdCenario2Produto1 >= 0) {
					if(qtdCenario2Produto2 >= 0) {
						System.out.println("\nQuantidade de " + produtoInserido1 + " a ser produzido(a) no cenário 2: " + qtdCenario2Produto1);
						System.out.println("Quantidade de " + produtoInserido2 + " a ser produzido(a) no cenário 2: " + qtdCenario2Produto2);
						System.out.printf("Lucro obtido nesse primeiro cenário: R$%.2f\n", lucroCenario2);
					}
					else {
						System.out.println("\nSolução inviável!");
					}
				}
				else {
					System.out.println("\nSolução inviável!");
				}
			}
			else {
				System.out.println("\nSolução inviável!");
			}
		}
		else {
			System.out.println("\nSolução inviável!");
		}
		
		//Iniciando a terceira comparação
		
		System.out.println("\nComparação I e IV: ");
		double qtdCenario3Produto1 = restricao1 / quantidadeDeMateriaPrimaGastosProduto1;
		p2.setProduto1(qtdCenario3Produto1);
		double qtdCenario3Produto2 = p2.getTerceiraComparacao(0, p1);
		double lucroCenario3 = p1.getLucroTotal() * qtdCenario3Produto1 + p2.getLucroTotal() * qtdCenario3Produto2;
		
		if(quantidadeDeMateriaPrimaGastosProduto1 * qtdCenario3Produto2 + quantidadeDeMateriaPrimaGastosProduto2 * qtdCenario3Produto1 <= restricao1) {
			if(quantidadeDeTempoGastosProduto1 * qtdCenario3Produto2 + quantidadeDeTempoGastosProduto2 * qtdCenario3Produto1 <= restricao2) {
				if(qtdCenario3Produto1 >= 0) {
					if(qtdCenario3Produto2 >= 0) {
						System.out.println("\nQuantidade de " + produtoInserido1 + " a ser produzido(a) no cenário 3: " + qtdCenario3Produto2);
						System.out.println("Quantidade de " + produtoInserido2 + " a ser produzido(a) no cenário 3: " + qtdCenario3Produto1);
						System.out.printf("Lucro obtido nesse primeiro cenário: R$%.2f\n", lucroCenario3);
					}
					else {
						System.out.println("\nSolução inviável!");
					}
				}
				else {
					System.out.println("\nSolução inviável!");
				}
			}
			else {
				System.out.println("\nSolução inviável!");
			}
		}
		else {
			System.out.println("\nSolução inviável!");
		}
		
		//Iniciando a quarta comparação
		
		double qtdCenario4Produto1 = p1.getQuartaComparacao(quantidadeDeMateriaPrimaGastosProduto1, p1);
		p2.setProduto1(qtdCenario4Produto1);
		double qtdCenario4Produto2 = restricao2 / quantidadeDeTempoGastosProduto2; 
		double lucroCenario4 = p1.getLucroTotal() * qtdCenario4Produto2 + p2.getLucroTotal() * qtdCenario4Produto1;
		
		System.out.println("\nComparação II e III: ");
		if(quantidadeDeMateriaPrimaGastosProduto1 * qtdCenario4Produto2 + quantidadeDeMateriaPrimaGastosProduto2 * qtdCenario4Produto1 <= restricao1) {
			if(quantidadeDeTempoGastosProduto1 * qtdCenario4Produto2 + quantidadeDeTempoGastosProduto2 * qtdCenario4Produto1 <= restricao2) {
				if(qtdCenario4Produto1 >= 0) {
					if(qtdCenario4Produto2 >= 0) {
						System.out.println("\nQuantidade de " + produtoInserido1 + " a ser produzido(a) no cenário 4: " + qtdCenario4Produto2);
						System.out.println("Quantidade de " + produtoInserido2 + " a ser produzido(a) no cenário 4: " + qtdCenario4Produto1);
						System.out.printf("Lucro obtido nesse primeiro cenário: R$%.2f\n", lucroCenario4);
					}
					else {
						System.out.println("\nSolução inviável!");
					}
				}
				else {
					System.out.println("\nSolução inviável!");
				}
			}
			else {
				System.out.println("\nSolução inviável!");
			}
		}
		else {
			System.out.println("\nSolução inviável!");
		}
		
		//quinta comparação
		System.out.println("\nComparação II e IV: ");
		double qtdCenario5Produto1 = restricao2 / quantidadeDeTempoGastosProduto1;
		p2.setProduto1(qtdCenario5Produto1);
		double qtdCenario5Produto2 = p2.getQuintaComparacao(quantidadeDeTempoGastosProduto2, p1); 
		double lucroCenario5 = p1.getLucroTotal() * qtdCenario5Produto2 + p2.getLucroTotal() * qtdCenario5Produto1;
		
		if(quantidadeDeMateriaPrimaGastosProduto1 * qtdCenario5Produto2 + quantidadeDeMateriaPrimaGastosProduto2 * qtdCenario5Produto1 <= restricao1) {
			if(quantidadeDeTempoGastosProduto1 * qtdCenario5Produto2 + quantidadeDeTempoGastosProduto2 * qtdCenario5Produto1 <= restricao2) {
				if(qtdCenario5Produto1 >= 0) {
					if(qtdCenario5Produto2 >= 0) {
						System.out.println("\nQuantidade de " + produtoInserido1 + " a ser produzido(a) no cenário 5: " + qtdCenario5Produto2);
						System.out.println("Quantidade de " + produtoInserido2 + " a ser produzido(a) no cenário 5: " + qtdCenario5Produto1);
						System.out.printf("Lucro obtido nesse primeiro cenário: R$%.2f\n", lucroCenario5);
					}
					else {
						System.out.println("\nSolução inviável!");
					}
				}
				else {
					System.out.println("\nSolução inviável!");
				}
			}
			else {
				System.out.println("\nSolução inviável!");
			}
		}
		else {
			System.out.println("\nSolução inviável!");
		}
		
		//sexta comparação
		System.out.println("\nComparação III e IV: ");
		double qtdCenario6Produto1 = 0;
		double qtdCenario6Produto2 = 0; 
		double lucroCenario6 = p1.getLucroTotal() * qtdCenario6Produto2 + p2.getLucroTotal() * qtdCenario6Produto1;
		
		if(quantidadeDeMateriaPrimaGastosProduto1 * qtdCenario6Produto2 + quantidadeDeMateriaPrimaGastosProduto2 * qtdCenario6Produto1 <= restricao1) {
			if(quantidadeDeTempoGastosProduto1 * qtdCenario6Produto2 + quantidadeDeTempoGastosProduto2 * qtdCenario6Produto1 <= restricao2) {
				if(qtdCenario6Produto1 >= 0) {
					if(qtdCenario6Produto2 >= 0) {
						System.out.println("\nQuantidade de " + produtoInserido1 + " a ser produzido(a) no cenário 6: " + qtdCenario6Produto2);
						System.out.println("Quantidade de " + produtoInserido2 + " a ser produzido(a) no cenário 6: " + qtdCenario6Produto1);
						System.out.printf("Lucro obtido nesse primeiro cenário: R$%.2f\n", lucroCenario6);
					}
					else {
						System.out.println("\nSolução inviável!");
					}
				}
				else {
					System.out.println("\nSolução inviável!");
				}
			}
			else {
				System.out.println("\nSolução inviável!");
			}
		}
		else {
			System.out.println("\nSolução inviável!");
		}
		
		sc.close();
	}

}
