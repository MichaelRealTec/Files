package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

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

	/*
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
	 */
	// FileReader (Stream (sequencia) de leitura de caractres a partir de arquivos)
	// BufferedReader (mais rápido)
}
