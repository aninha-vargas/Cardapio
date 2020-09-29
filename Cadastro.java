package br.edu.up.sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.edu.up.dominio.Bebida;
import br.edu.up.dominio.Prato;
import br.edu.up.dominio.Vinho;

public class Cadastro {  //ATIVIDADE 5 CARDAPIO
	
	public static List<Prato> getListaDePratos(String nomeDoArquivo) throws FileNotFoundException{
		File arquivo = new File(nomeDoArquivo);
	    Scanner leitor = new Scanner(new FileInputStream(arquivo));
	    leitor.nextLine();
		
		List<Prato> listaDePratos = new ArrayList<>();
		
		while (leitor.hasNext()) {
	        
			String linha = leitor.nextLine();
		    String[] partes = linha.split(";");
		    String nome = partes[0];
		    String strPreco = partes[1];
		    double preco = Double.parseDouble(strPreco);
		    
		    Prato prato = new Prato();
		    prato.setNome(nome);
		    prato.setPreco(preco);
		       
		    listaDePratos.add(prato);
		}
		leitor.close();
		return listaDePratos;
	}
		
	public static List<Vinho> getListaDeVinhos(String nomeDoArquivo) throws FileNotFoundException{
		File arquivo = new File(nomeDoArquivo);
	    Scanner leitor = new Scanner(new FileInputStream(arquivo));
	    leitor.nextLine();
				    
	    List<Vinho> listaDeVinhos = new ArrayList<>();
		    
		while (leitor.hasNext()) {
		        
			String linha = leitor.nextLine();
		    String[] partes = linha.split("\t");
		    String nome = partes[1];
		    String strPreco = partes[0];
		    double preco = Double.parseDouble(strPreco);

		    Vinho vinho = new Vinho();
		    vinho.setNome(nome);
		    vinho.setPreco(preco);
		       
		    listaDeVinhos.add(vinho);
		}
		leitor.close();
		return listaDeVinhos;
	}
	
	public static List<Bebida> getListaDeBebidas(String nomeDoArquivo) throws FileNotFoundException{
		File arquivo = new File(nomeDoArquivo);
	    Scanner leitor = new Scanner(new FileInputStream(arquivo));
	    leitor.nextLine();
	    
	    List<Bebida> listaDeBebidas = new ArrayList<>();
	    
	    while (leitor.hasNext()) {
	        
	        String linha = leitor.nextLine();
	        String[] partes = linha.split("\t");
	        String nome = partes[1];
	        String strPreco = partes[0];
	        String strPonto = strPreco.replace(",", ".");
	        double preco = Double.parseDouble(strPonto);

	        
	        Bebida bebida = new Bebida();
	        bebida.setNome(nome);
	        bebida.setPreco(preco);
	       
	        listaDeBebidas.add(bebida);
	    }
	    leitor.close();
	    return listaDeBebidas;
	}
		
	public static void incluirPrato(Prato prato) {
		try {
			FileWriter arquivo = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\pratos.csv", true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println(prato.getNome() + ";" + prato.getPreco());
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void incluirBebida(Bebida bebida) {
		try {
			FileWriter arquivo = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\bebidas-tabuladas.txt", true);
			PrintWriter gravador = new PrintWriter(arquivo);
			String str = String.valueOf(bebida.getPreco()).replace(".", ",");
			gravador.println(str + "\t" + bebida.getNome());
			//gravador.println(bebida.getPreco() + "\t" + bebida.getNome());
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void incluirVinho(Vinho vinho) {
		try {
			FileWriter arquivo = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\vinhos-tabulados.txt", true);
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println(vinho.getPreco() + "\t" + vinho.getNome());
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Prato buscarPrato(String query) throws FileNotFoundException {
		
		List<Prato> pratos = Cadastro.getListaDePratos("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\pratos.csv");
		
		Prato pratoEncontrado = null;
		for (Prato prato : pratos) {
			if (prato.getNome().contains(query)) {
				pratoEncontrado = prato;
				break;
			}
		}
		return pratoEncontrado;
	}
	
	public static Bebida buscarBebida(String query) throws FileNotFoundException {
		
		List<Bebida> bebidas = Cadastro.getListaDeBebidas("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\bebidas-tabuladas.txt");
		
		Bebida bebidaEncontrada = null;
		for (Bebida bebida : bebidas) {
			if (bebida.getNome().contains(query)) {
				bebidaEncontrada = bebida;
				break;
			}
		}
		return bebidaEncontrada;
	}
	
	public static Vinho buscarVinho(String query) throws FileNotFoundException {
		
		List<Vinho> vinhos = Cadastro.getListaDeVinhos("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\vinhos-tabulados.txt");
		
		Vinho vinhoEncontrado = null;
		for (Vinho vinho : vinhos) {
			if (vinho.getNome().contains(query)) {
				vinhoEncontrado = vinho;
				break;
			}
		}
		return vinhoEncontrado;
	}

	public static void atualizarPrato(Prato prato) {
		try {
			
			List<Prato> pratos = Cadastro.getListaDePratos("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\pratos.csv");
			for (Prato p : pratos) {
				if (p.getNome().equals(prato.getNome())) {
					p.setPreco(prato.getPreco());
				}
			}
			
			FileWriter arquivo = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\pratos.csv");
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("PRATO;PRECO");
			
			for (Prato p : pratos) {
				gravador.println(p.getNome() + ";" + p.getPreco());
			}
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void atualizarBebida(Bebida bebida) {
		try {
			
			List<Bebida> bebidas = Cadastro.getListaDeBebidas("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\bebidas-tabuladas.txt");
			for (Bebida b : bebidas) {
				if (b.getNome().equals(bebida.getNome())) {
					b.setPreco(bebida.getPreco());
				}
			}
			
			FileWriter arquivo = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\bebidas-tabuladas.txt");
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("PRECO" + "\t" + "BEBIDA");
			
			for (Bebida b : bebidas) {
				String str = String.valueOf(b.getPreco()).replace(".", ",");
				gravador.println(str + "\t" + b.getNome());
				//gravador.println(b.getPreco() + "\t" + b.getNome() );
			}
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void atualizarVinho(Vinho vinho) {
		try {
			
			List<Vinho> vinhos = Cadastro.getListaDeVinhos("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\vinhos-tabulados.txt");
			for (Vinho v : vinhos) {
				if (v.getNome().equals(vinho.getNome())) {
					v.setPreco(vinho.getPreco());
				}
			}
			
			FileWriter arquivo = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\vinhos-tabulados.txt");
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("PRECO" + "\t" + "VINHO");
			
			for (Vinho v : vinhos) {
				gravador.println(v.getPreco() + "\t" + v.getNome() );
			}
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void excluirPrato(Prato pratoRetornado) throws FileNotFoundException {
		List<Prato> pratos = Cadastro.getListaDePratos("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\pratos.csv");
		for (int i = 0; i < pratos.size(); i++){
			  Prato prato = pratos.get(i);
				if(prato.getNome().equals(pratoRetornado.getNome())){
				 pratos.remove(prato);
				}
			}
		
		try {
			FileWriter arquivo = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\pratos.csv");
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("PRATO;PRECO");
			
			for (Prato p : pratos) {
				gravador.println(p.getNome() + ";" + p.getPreco());
			}
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void excluirBebida(Bebida bebidaRetornada) throws FileNotFoundException {
		List<Bebida> bebidas = Cadastro.getListaDeBebidas("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\bebidas-tabuladas.txt");
		for (int i = 0; i < bebidas.size(); i++){
			  Bebida bebida = bebidas.get(i);
				if(bebida.getNome().equals(bebidaRetornada.getNome())){
				 bebidas.remove(bebida);
				}
			}
		
		try {
			FileWriter arquivo = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\bebidas-tabuladas.txt");
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("PRECO" + "\t" + "BEBIDA");
			
			for (Bebida b : bebidas) {
				String str = String.valueOf(b.getPreco()).replace(".", ",");
				gravador.println(str + "\t" + b.getNome());
				//gravador.println(b.getPreco() + "\t" + b.getNome());
			}
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void excluirVinho(Vinho vinhoRetornado) throws FileNotFoundException {
		List<Vinho> vinhos = Cadastro.getListaDeVinhos("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\vinhos-tabulados.txt");
		for (int i = 0; i < vinhos.size(); i++){
			  Vinho vinho = vinhos.get(i);
				if(vinho.getNome().equals(vinhoRetornado.getNome())){
				 vinhos.remove(vinho);
				}
			}
		
		try {
			FileWriter arquivo = new FileWriter("C:\\Users\\aninh\\Desktop\\Faculdade\\DSoftware\\Atividade 5\\vinhos-tabulados.txt");
			PrintWriter gravador = new PrintWriter(arquivo);
			gravador.println("PRECO" + "\t" + "VINHO");
			
			for (Vinho v : vinhos) {
				gravador.println(v.getPreco() + "\t" + v.getNome());
			}
			gravador.close();
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
