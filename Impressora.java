package br.edu.up.sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Impressora {  //ATIVIDADE 5 CARDAPIO
	public static void pedido (List<Bebida> pedidoBebida, List<Vinho> pedidoVinho, List<Prato> pedidoPrato, double somaBebida, double somaVinho, double somaPrato, String obspedido) throws IOException {
		
		double totalPedido = somaBebida + somaVinho + somaPrato;
		
		
		FileWriter arquivoSaida = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\pedido.txt", true);
	    PrintWriter gravador = new PrintWriter(arquivoSaida);
	    
	    gravador.println();
	    gravador.println("----------------------PEDIDO DE BEBIDAS-----------------------------");
	    gravador.println();
		for (Bebida bebida : pedidoBebida) {
			gravador.println(bebida.getNome() + "......" + bebida.getPreco());
		}
		gravador.println("-----------------------PEDIDO DE VINHO------------------------------");
		gravador.println();
	    for (Vinho vinho : pedidoVinho) {
	    	gravador.println(vinho.getNome() + "......" + vinho.getPreco());
		}
	    gravador.println("-----------------------PEDIDO DE PRATO------------------------------");
	    gravador.println();
	    for (Prato prato : pedidoPrato) {
	    	gravador.println(prato.getNome() + "......." + prato.getPreco());
		}
	    
	    gravador.println();
	    gravador.println("____________________________________________________________________");
	    gravador.println();
	    gravador.println("    TOTAL PEDIDO:............................." + totalPedido);
	    gravador.println("____________________________________________________________________");
	    gravador.println();
	    gravador.println("OBSERVAÇÕES: " + obspedido);
	    gravador.println();
	    gravador.println("**************************FIM DO PEDIDO*****************************");
	    gravador.println();
	    
	    gravador.close();
	    arquivoSaida.close();
	}

}
