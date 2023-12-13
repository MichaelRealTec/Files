package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		// FileWrites ( Stream de escrita de caracteres em arquivos )
			// Cria / recria o arquivo: new FileWriter(path) (observação: este comando apaga o arquivo e começa escrever ou cria do zero caso não exista.)
		    // Acrescednta ao arquivo existente: new FileWriter(path, true) (observação: este comando acrescenta linhas ao final do arquivo)
		
		// BufferedWriter (mais rápido) trabalha com cache no buffer
		
				
		// Atributos
		String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		
		
		String path = "c:\\temp\\out.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
					
	}
	
}
		
		
		/* ******************************************************************************************************
		
		
		
		// Bloco try-with-resources
		 // É um bloco try que declara um ou mais recursos, e garante que esses recursos serão fechados ao final do bloco
		  // ( fecha automaticamente as Streams
		
		//Atributos
		String path = "c:\\temp\\in.txt";
		
		
		
		// FileReader (Stream (sequencia) de leitura de caractres a partir de arquivos)
		// BufferedReader (mais rápido)

		try (BufferedReader br = new BufferedReader(new FileReader(path))){
				// ou br = new BufferedReader(new FileReader(path));

			String line = br.readLine(); // vai ler uma linha do arquivo e se o arquivo estiver no final retornará nulo
	
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}	
		/* ****************************************************************************************
		
		// Processo para mostrar como funciona manualmente as Streams

		// Atributos
		String path = "c:\\temp\\in.txt";
		FileReader fr = null;
		BufferedReader br = null;

		// FileReader (Stream (sequencia) de leitura de caractres a partir de arquivos)
		// BufferedReader (mais rápido)

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr); // ou br = new BufferedReader(new FileReader(path));

			String line = br.readLine(); // vai ler uma linha do arquivo e se o arquivo estiver no final retornará nulo
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}


	 * Lendo arquivo texto com classes Scanner sc = null; File file = new
	 * File("c:\\temp\\in.txt"); try { sc = new Scanner(file); while
	 * (sc.hasNextLine()) { // TESTAR PARA VER SE EXISTE UMA NOVA LINHA NO ARQUIVO
	 * System.out.println(sc.nextLine()); } }
	 * 
	 * catch (IOException e) { // Se aparecer alguma exceção
	 * System.out.println("Error: " + e.getMessage()); } finally { // Finalizando o
	 * Scanner sc! if (sc != null) { sc.close(); }
	 * 
	 * }
	 * 
	 * }
	 
	// FileReader (Stream (sequencia) de leitura de caractres a partir de arquivos)
	// BufferedReader (mais rápido)
		
		*/

