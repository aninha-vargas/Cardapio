package br.edu.up.sistema;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Gestao {
	
	public static void processar(List<Bebida> listaDeBebidas, List<Vinho> listaDeVinhos, List<Prato> listaDePratos) throws IOException {
		Scanner leitor = new Scanner(System.in); 
		
		int contador = 1;
		while (contador != 0 ) {
			
			System.out.println();
		    System.out.println("QUANTO AO CARDÁRIO, DESEJA: ");
		    System.out.println("   1  -  LISTAR");
			System.out.println("   2  -  INCLUIR");
			System.out.println("   3  -  ATUALIZAR");
			System.out.println("   4  -  EXCLUIR");
			System.out.println();
			System.out.println("DIGITE SUA OPÇÃO: ");
			int opcaoAdm = leitor.nextInt();
			leitor.nextLine();
			System.out.println("****************************************************");
			
			if (opcaoAdm == 1) { //LISTAR
				 System.out.println();
				 System.out.println("QUAL MENU LISTAR? ");
				 System.out.println("   1  -  Prato");
				 System.out.println("   2  -  Bebida");
				 System.out.println("   3  -  Vinho");
				 int opcaoListar = leitor.nextInt();
				 leitor.nextLine();
				 System.out.println("****************************************************");
				 System.out.println();
				 
				 if (opcaoListar == 1) {//PRATO
					 for (Prato prato : listaDePratos) {
						System.out.println(prato.getNome() +"----------" + prato.getPreco());
					}
				 }
				 
				 if (opcaoListar == 2) {//BEBIDA
					 for (Bebida bebida : listaDeBebidas) {
						System.out.println(bebida.getNome() +"----------" + bebida.getPreco()); 
					 }
				 }
				 
				 if (opcaoListar == 3) {//VINHO
					 for (Vinho vinho : listaDeVinhos) {
						 System.out.println(vinho.getNome() +"----------" + vinho.getPreco()); 
					 }
				 }
				 
				 System.out.println("****************************************************");
				 System.out.println();
				 System.out.println("DESEJA RETORNAR A MANUTENÇÃO DO CARDÁPIO? ");
				 System.out.println("DIGITE: 1-SIM OU 0-NÃO ");
				 contador = leitor.nextInt();
				 leitor.nextLine();
				 System.out.println("****************************************************");
			}
			
			if (opcaoAdm == 2) { //INCLUIR
				 System.out.println("EM QUAL MENU INCLUIR? ");
				 System.out.println("   1  -  Prato");
				 System.out.println("   2  -  Bebida");
				 System.out.println("   3  -  Vinho");
				 int opcaoIncluir = leitor.nextInt();
				 leitor.nextLine();
				 System.out.println("****************************************************");
				 System.out.println();
				 
				 if (opcaoIncluir == 1) {//PRATO
					 Prato prato = new Prato();
					 System.out.println("Nome do prato: ");
					 String nomePrato = leitor.nextLine();
					 prato.setNome(nomePrato);
					 System.out.println("Valor do prato (centavos separar com virgula): ");
					 Double valorPrato = leitor.nextDouble();
					 prato.setPreco(valorPrato);
					 Cadastro.incluirPrato(prato);
					 System.out.println();
					 System.out.println("INCLUÍDO COM SUCESSO");
				 }
				 
				 if (opcaoIncluir == 2) {//BEBIDA
					 Bebida bebida = new Bebida();
					 System.out.println("Nome da bebida: ");
					 String nomeBebida = leitor.nextLine();
					 bebida.setNome(nomeBebida);
					 System.out.println("Valor da bebida (centavos separar com virgula): ");
					 Double valorBebida = leitor.nextDouble();
					 bebida.setPreco(valorBebida);
					 Cadastro.incluirBebida(bebida);
					 System.out.println();
					 System.out.println("INCLUÍDO COM SUCESSO");
				 }
				 
				 if (opcaoIncluir == 3) {//VINHO
					 Vinho vinho = new Vinho();
					 System.out.println("Nome do vinho: ");
					 String nomeVinho = leitor.nextLine();
					 vinho.setNome(nomeVinho);
					 System.out.println("Valor do vinho (centavos separar com virgula): ");
					 Double valorVinho = leitor.nextDouble();
					 vinho.setPreco(valorVinho);
					 Cadastro.incluirVinho(vinho);
					 System.out.println();
					 System.out.println("INCLUÍDO COM SUCESSO");
				 }
				 
				 System.out.println("****************************************************");
				 System.out.println();
				 System.out.println("DESEJA RETORNAR A MANUTENÇÃO DO CARDÁPIO? ");
				 System.out.println("DIGITE: 1-SIM OU 0-NÃO ");
				 contador = leitor.nextInt();
				 leitor.nextLine();
				 System.out.println("****************************************************");
			}
			
			if (opcaoAdm == 3) {//ATUALIZAR
				 System.out.println("QUAL MENU ATUALIZAR? ");
				 System.out.println("   1  -  Prato");
				 System.out.println("   2  -  Bebida");
				 System.out.println("   3  -  Vinho");
				 int opcaoAtualizar = leitor.nextInt();
				 leitor.nextLine();
				 System.out.println("****************************************************");
				 System.out.println();
				 
				 if (opcaoAtualizar == 1) {//PRATO
					 System.out.println("Digite o prato que deseja atualizar: ");
					 String query = leitor.nextLine();
					 Prato pratoRetornado = Cadastro.buscarPrato(query);
					 if (pratoRetornado == null) {
					    	System.out.println("Prato não encontrado!");
					    } else {
					    	System.out.println("Prato: "+ pratoRetornado.getNome());
					    	System.out.println("Valor: R$ "+ pratoRetornado.getPreco());
					    	System.out.println("Digite o novo valor (centavos separar com virgula): ");
							Double valorPrato = leitor.nextDouble();
					    	pratoRetornado.setPreco(valorPrato);
						    Cadastro.atualizarPrato(pratoRetornado);
						    System.out.println();
							System.out.println("ATUALIZADO COM SUCESSO");
					    }
				 }
				 
				 if (opcaoAtualizar == 2) {//BEBIDA
					 System.out.println("Digite a bebida que deseja atualizar: ");
					 String query = leitor.nextLine();
					 Bebida bebidaRetornada = Cadastro.buscarBebida(query);
					 if (bebidaRetornada == null) {
					    	System.out.println("Bebida não encontrada!");
					    } else {
					    	System.out.println("Bebida: "+ bebidaRetornada.getNome());
					    	System.out.println("Valor: R$ "+ bebidaRetornada.getPreco());
					    	System.out.println("Digite o novo valor (centavos separar com virgula): ");
							Double valorBebida = leitor.nextDouble();
							bebidaRetornada.setPreco(valorBebida);
							Cadastro.atualizarBebida(bebidaRetornada);
							System.out.println();
							System.out.println("ATUALIZADO COM SUCESSO");
					    }
				 }
				 
				 if (opcaoAtualizar == 3) {//VINHO
					 System.out.println("Digite o vinho que deseja atualizar: ");
					 String query = leitor.nextLine();
					 Vinho vinhoRetornado = Cadastro.buscarVinho(query);
					 if (vinhoRetornado == null) {
					    	System.out.println("Vinho não encontrado!");
					    } else {
					    	System.out.println("Vinho: "+ vinhoRetornado.getNome());
					    	System.out.println("Valor: R$ "+ vinhoRetornado.getPreco());
					    	System.out.println("Digite o novo valor (centavos separar com virgula): ");
							Double valorVinho = leitor.nextDouble();
							vinhoRetornado.setPreco(valorVinho);
							Cadastro.atualizarVinho(vinhoRetornado);
							System.out.println();
							System.out.println("ATUALIZADO COM SUCESSO");
					    }
					   
				 }
				 
				 System.out.println("****************************************************");
				 System.out.println();
				 System.out.println("DESEJA RETORNAR A MANUTENÇÃO DO CARDÁPIO? ");
				 System.out.println("DIGITE: 1-SIM OU 0-NÃO ");
				 contador = leitor.nextInt();
				 leitor.nextLine();
				 System.out.println("****************************************************");
			}
			
			if (opcaoAdm == 4) {//EXCLUIR
				 System.out.println("DE QUAL MENU SERÁ EXCLUÍDO ITEM? ");
				 System.out.println("   1  -  Prato");
				 System.out.println("   2  -  Bebida");
				 System.out.println("   3  -  Vinho");
				 int opcaoExcluir = leitor.nextInt();
				 leitor.nextLine();
				 System.out.println("****************************************************");
				 System.out.println();
				 
				 if (opcaoExcluir == 1) {//PRATO
					 System.out.println("Digite o prato que deseja excluir: ");
					 String query = leitor.nextLine();
					 Prato pratoRetornado = Cadastro.buscarPrato(query);
					 if (pratoRetornado == null) {
					    	System.out.println("Prato não encontrado!");
					 } else {
					    	System.out.println("Prato: "+ pratoRetornado.getNome());
					    	System.out.println("Valor: R$ "+ pratoRetornado.getPreco());
					    	Cadastro.excluirPrato(pratoRetornado);
					    	System.out.println();
							System.out.println("EXCLUÍDO COM SUCESSO");
					 }
				 }
				 
				 if (opcaoExcluir == 2) {//BEBIDA
					 System.out.println("Digite a bebida que deseja excluir: ");
					 String query = leitor.nextLine();
					 Bebida bebidaRetornada = Cadastro.buscarBebida(query);
					 
					 if (bebidaRetornada == null) {
						 System.out.println("Bebida não encontrada!");
					 } else {
						 System.out.println("Bebida: "+ bebidaRetornada.getNome());
					     System.out.println("Valor: R$ "+ bebidaRetornada.getPreco());
					     Cadastro.excluirBebida(bebidaRetornada);
					     System.out.println();
						 System.out.println("EXCLUÍDO COM SUCESSO");
					 }
				 }
				 
				 if (opcaoExcluir == 3) {//VINHO
					 System.out.println("Digite o vinho que deseja excluir: ");
					 String query = leitor.nextLine();
					 Vinho vinhoRetornado = Cadastro.buscarVinho(query);
					 if (vinhoRetornado == null) {
						 System.out.println("Vinho não encontrado!");
					 } else {
						 System.out.println("Vinho: "+ vinhoRetornado.getNome());
					     System.out.println("Valor: R$ "+ vinhoRetornado.getPreco());
					     Cadastro.excluirVinho(vinhoRetornado);
					     System.out.println();
						 System.out.println("EXCLUÍDO COM SUCESSO");
					 }
				 }
				 
				 System.out.println("****************************************************");
				 System.out.println();
				 System.out.println("DESEJA RETORNAR A MANUTENÇÃO DO CARDÁPIO? ");
				 System.out.println("DIGITE: 1-SIM OU 0-NÃO ");
				 contador = leitor.nextInt();
				 leitor.nextLine();
				 System.out.println("****************************************************");				
			}
		}
		System.out.println();
		System.out.println("******************* FIM DO PROGRAMA ****************");
		System.out.println();
		leitor.close();
	}
}
