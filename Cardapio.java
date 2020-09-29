package br.edu.up.sistema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Cardapio {  //ATIVIDADE 5 CARDAPIO
	
	public static void processar(List<Bebida> listaDeBebidas, List<Vinho> listaDeVinhos, List<Prato> listaDePratos) throws IOException {
		Scanner leitor = new Scanner(System.in);
		
		List<Bebida> pedidoBebida = new ArrayList<>();
		List<Vinho> pedidoVinho = new ArrayList<>();
		List<Prato> pedidoPrato = new ArrayList<>();
		double somaBebida = 0;
		double somaVinho = 0;
		double somaPrato = 0;
		String obspedido = "SEM OBS";
		
		int contador = 1;
		while (contador != 0 ){
			
			
			System.out.println("*************OP합ES***************");
			System.out.println();
			System.out.println("         1  -  BEBIDA");
			System.out.println("         2  -  VINHO");
			System.out.println("         3  -  PRATO");
			System.out.println();
			System.out.println("DIGITE SUA OP플O: ");
			int menu = leitor.nextInt();
			leitor.nextLine();
			
						
			if (menu==1) {
				int i = 0;
								
				
				System.out.println("*************BEBIDAS***************");
				System.out.println();
				for (Bebida bebida : listaDeBebidas) {
					System.out.println(i +" - " + bebida.getNome() +"----------" + bebida.getPreco());
					i++;
				
				}
				System.out.println();
				System.out.println();
				System.out.println("DIGITE SUA OP플O: ");
				int escolhaBebida = leitor.nextInt();
				leitor.nextLine();
								
				Bebida bebidaSelecionada = listaDeBebidas.get(escolhaBebida);
				pedidoBebida.add(bebidaSelecionada);
				somaBebida = somaBebida + bebidaSelecionada.getPreco();
				
			}else if (menu==2) {
				int i =0;
				
				System.out.println("*************VINHOS***************");
				System.out.println();
				for (Vinho vinho : listaDeVinhos) {
					System.out.println(i +" - " + vinho.getNome() +"----------" + vinho.getPreco());
					i++;
				}
				System.out.println();
				System.out.println();
				System.out.println("DIGITE SUA OP플O: ");
				int escolhaVinho = leitor.nextInt();
				leitor.nextLine();
				
				Vinho vinhoSelecionado = listaDeVinhos.get(escolhaVinho);
				pedidoVinho.add(vinhoSelecionado);
				somaVinho = somaVinho + vinhoSelecionado.getPreco();
								
			}else if (menu==3) {
				int i = 0;
				
				System.out.println("*************PRATOS***************");
				System.out.println();
				for (Prato prato : listaDePratos) {
					System.out.println(i +" - " + prato.getNome() +"----------" + prato.getPreco());
					i++;
				}
				System.out.println();
				System.out.println();
				System.out.println("DIGITE SUA OP플O: ");
				int escolhaPrato = leitor.nextInt();
				leitor.nextLine();
				
				Prato pratoSelecionado = listaDePratos.get(escolhaPrato);
				pedidoPrato.add(pratoSelecionado);
				somaPrato = somaPrato + pratoSelecionado.getPreco();
				}
			
			System.out.println();
			System.out.println();
			System.out.println("DESEJA VOLTAR AO MENU? ");
			System.out.println("DIGITE: 1 - SIM OU 0 - N홒");
			contador = leitor.nextInt();
			leitor.nextLine();
			System.out.println();
			
		}
		
		System.out.println("DESEJA INCLUIR ALGUMA OBSERVA플O? ");
		obspedido = leitor.nextLine();
		System.out.println();
		System.out.println("********PEDIDO FINALIZADO**********");
		
			
		leitor.close();
		
		Impressora.pedido(pedidoBebida,pedidoVinho, pedidoPrato,somaBebida,somaVinho, somaPrato, obspedido);
	}
}
