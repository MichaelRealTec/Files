
// Atividade
/*
 * Fazer um programa para ler o caminho de um arquivo .csv contendo os dados de
 * itens vendidos. Cada item possui um nome, preço unitário e quantidade,
 * separados por vírgula. Você deve gerar um novo arquivo chamado "summary.csv",
 * localizado em uma subpasta chamada "out" a partir da pasta original do
 * arquivo de origem, contendo apenas o nome e o valor total para aquele item
 * (preço unitário multiplicado pela quantidade), conforme exemplo.
 * 
 * Souce file: (Arquivos de entrada) TV LED, 1290.99,1 Video Game Chair, 350.50,
 * 3 Iphone X, 900.00,2 Samsung Galaxy 9, 850.00,2
 * 
 * Output file (out/summary.csv): TV LED, 1290.99 Video Game Chair, 1051.50
 * Iphone X, 1800.00 Samsung Galaxy 9, 1700.00
 * 
 */

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();

		boolean success = new File(sourceFolderStr + "\\out").mkdir();

		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Product(name, price, quantity));

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

				for (Product item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}

				System.out.println(targetFileStr + " CREATED!");

			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}

/*
 * try { sc = new Scanner(file); list = sc; while (sc.hasNextLine()) {
 * System.out.println(sc.nextLine()); } } catch(IOException e) {
 * System.out.println("Error: " + e.getMessage()); } finally { if(sc != null) {
 * sc.close(); } }
 * 
 * /* // Usar a função slit (pegar antes da virgula) // Instanciar objeto
 * produto // Criar uma lista para guardar os itens List<Product> list = new
 * ArrayList<>();
 * System.out.println("Digite a quantidade de produtos a ser acrescentado: ");
 * int n = sc.nextInt(); System.out.println("Digite os dados do produto: ");
 * 
 * 
 * for (int i = 1; i <= n; i++) { sc.nextLine(); System.out.print("Name: ");
 * name = sc.nextLine(); System.out.print("Price: "); price = sc.nextDouble();
 * System.out.print("Quantity: "); quantity = sc.nextInt(); Product product =
 * new Product(name, price, quantity); list.add(product) ; }
 * 
 * System.out.println(list); /* for (Product List : list) {
 * System.out.println(list); }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * sc.close();
 * 
 */

/*
 * *****************************************************************************
 * *********************
 * 
 * // Obtendo informações do caminho do arquivo
 * 
 * // Atributos
 * 
 * Scanner sc = new Scanner(System.in); // Criando leitura via teclado
 * System.out.println("Enter a file path: "); String strPath = sc.nextLine(); //
 * Lendo a linha
 * 
 * File path = new File(strPath); // pega somente o nome do arquivo desprezando
 * o caminho
 * 
 * System.out.println("getName: " + path.getName()); // Imprime somente o nome
 * do arquivo
 * 
 * // Mostrar apenas o caminho System.out.println("getParent: " +
 * path.getParent()); // Imprime somente o caminho do arquivo
 * 
 * // Mostrar todo o caminho System.out.println("getPah: " + path.getPath()); //
 * Mostra o caminho completo
 * 
 * 
 * sc.close(); } }
 * 
 * 
 * 
 * 
 * 
 * /*
 * *****************************************************************************
 * *****************
 * 
 * // Manipulando pastas com File
 * 
 * 
 * // Atributos
 * 
 * Scanner sc = new Scanner(System.in);
 * System.out.println("Enter a folder path: "); String strPath = sc.nextLine();
 * 
 * File path = new File(strPath);
 * 
 * File[] folders = path.listFiles(File::isDirectory); // Vai criar um vetor de
 * files contendo cada caminho das pastas System.out.println("FOLDERS:"); for
 * (File folder : folders) { // Lista as pastas do caminho escolhido
 * System.out.println(folder); // mostra na tela as pastas }
 * 
 * // Agora quero saber os arquivos dentro da pasta especificada File[] files =
 * path.listFiles(File::isFile); // Lista os arquivos do caminho escolhido
 * System.out.println("FILES:");
 * 
 * for (File file : files) { System.out.println(file); // mostra na tela os
 * arquivos }
 * 
 * // Criar uma subpasta a partir da pasta temp boolean success = new
 * File(strPath + "\\subdir").mkdir(); // Criou a subpast subdir dentro do
 * camiho especificado System.out.println("Directory created succesfully: " +
 * success);
 * 
 * sc.close(); }
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * /*
 * *****************************************************************************
 * ****************************
 * 
 * 
 * // FileWrites ( Stream de escrita de caracteres em arquivos ) // Cria /
 * recria o arquivo: new FileWriter(path) (observação: este comando apaga o
 * arquivo e começa escrever ou cria do zero caso não exista.) // Acrescednta ao
 * arquivo existente: new FileWriter(path, true) (observação: este comando
 * acrescenta linhas ao final do arquivo)
 * 
 * // BufferedWriter (mais rápido) trabalha com cache no buffer
 * 
 * 
 * // Atributos String[] lines = new String[] {"Good morning", "Good afternoon",
 * "Good night"};
 * 
 * 
 * String path = "c:\\temp\\out.txt";
 * 
 * try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
 * for(String line : lines) { bw.write(line); bw.newLine(); }
 * 
 * } catch(IOException e) { e.printStackTrace(); }
 * 
 * }
 * 
 * }
 * 
 * 
 * /*
 * *****************************************************************************
 * *************************
 * 
 * 
 * 
 * // Bloco try-with-resources // É um bloco try que declara um ou mais
 * recursos, e garante que esses recursos serão fechados ao final do bloco // (
 * fecha automaticamente as Streams
 * 
 * //Atributos String path = "c:\\temp\\in.txt";
 * 
 * 
 * 
 * // FileReader (Stream (sequencia) de leitura de caractres a partir de
 * arquivos) // BufferedReader (mais rápido)
 * 
 * try (BufferedReader br = new BufferedReader(new FileReader(path))){ // ou br
 * = new BufferedReader(new FileReader(path));
 * 
 * String line = br.readLine(); // vai ler uma linha do arquivo e se o arquivo
 * estiver no final retornará nulo
 * 
 * while (line != null) { System.out.println(line); line = br.readLine(); } }
 * catch(IOException e) { System.out.println("Error: " + e.getMessage()); }
 * 
 * } } /*
 * *****************************************************************************
 * ***********
 * 
 * // Processo para mostrar como funciona manualmente as Streams
 * 
 * // Atributos String path = "c:\\temp\\in.txt"; FileReader fr = null;
 * BufferedReader br = null;
 * 
 * // FileReader (Stream (sequencia) de leitura de caractres a partir de
 * arquivos) // BufferedReader (mais rápido)
 * 
 * try { fr = new FileReader(path); br = new BufferedReader(fr); // ou br = new
 * BufferedReader(new FileReader(path));
 * 
 * String line = br.readLine(); // vai ler uma linha do arquivo e se o arquivo
 * estiver no final retornará nulo while (line != null) {
 * System.out.println(line); line = br.readLine(); }
 * 
 * } catch (IOException e) { System.out.println("Error: " + e.getMessage()); }
 * finally { try { if (br != null) { br.close(); } if (fr != null) { fr.close();
 * } } catch (IOException e) { e.printStackTrace(); }
 * 
 * } }
 * 
 * 
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
 * 
 * // FileReader (Stream (sequencia) de leitura de caractres a partir de
 * arquivos) // BufferedReader (mais rápido)
 * 
 */
