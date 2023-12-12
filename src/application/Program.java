package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// Atributos
		Scanner sc = null;
		File file = new File("c:\\temp\\in.txt");
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}

		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			// Finalizando o Scanner sc!
			sc.close();
		}

	}

}