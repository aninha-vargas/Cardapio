# Cardapio

package br.edu.up.sistema;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Programa {

	public static void main(String[] args) throws IOException { //ATIVIDADE 5 CARDAPIO
				
		//ENTRADA
	    List<Bebida> listaDeBebidas = Cadastro.getListaDeBebidas("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\bebidas-tabuladas.txt");
	    List<Vinho> listaDeVinhos = Cadastro.getListaDeVinhos("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\vinhos-tabulados.txt");
	    List<Prato> listaDePratos = Cadastro.getListaDePratos("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\pratos.csv");
	    
	    Scanner leitor = new Scanner(System.in);
	    System.out.println();
	    System.out.println("*************OPÇÕES***************");
	    System.out.println();
	    System.out.println("   1  -  ACESSO ADMINISTRATIVO");
		System.out.println("   2  -  ACESSO CLIENTE");
		System.out.println();
		System.out.println("**********************************");
		System.out.println();
		System.out.println("DIGITE SUA OPÇÃO: ");
		int opcao = leitor.nextInt();
		leitor.nextLine();
		System.out.println();
	    
		if (opcao == 1) {
			Gestao.processar(listaDeBebidas, listaDeVinhos, listaDePratos);
		}
		if (opcao == 2) {
			Cardapio.processar(listaDeBebidas, listaDeVinhos, listaDePratos);
		}
	    
	    leitor.close();
	}
}
