package s1t3n1exercici3;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.lang.Math;

public class Main {

	public static void main(String[] args) {
		
		//Preguntem pel nom del jugador		
		String nom = JOptionPane.showInputDialog("Com et dius?");
		
		//Creem un HashMap on guardarem els paisos i capitals de l'arxiu		
		HashMap<String, String> paisos_capitals = new HashMap<String, String>();
		
		//Obrim l'arxiu		
		obrir_arxiu(paisos_capitals);	
		
		//Fem el quizz i retornem el total de respostes acertades		
		int total = quizz(paisos_capitals);
		
		//Extra: Imprimim per pantalla el que veurem a l'arxiu		
		System.out.println("Molt bé " + nom + ", has acertat " + total + " capitals.");	
		
		//Obrim un arxiu i escrivim el resultat
		resultat_quizz(nom, total);		
	}
	
	public static void obrir_arxiu(HashMap<String, String> paisos_capitals) {
		
		//Obrim l'arxiu fent servir Scanner
		try {

		File countries_txt = new File("Countries.txt");
		
		Scanner countries = new Scanner(countries_txt);
		
		while (countries.hasNext()) {
					
			paisos_capitals.put(countries.next(),countries.next());
				
		}
		countries.close();
		
		} catch (FileNotFoundException e) {
			
			System.out.println("Fitxer no trobat");	
		}	
	}
	
	public static int quizz(HashMap<String, String> paisos_capitals) {
		
		int count = 0;

		for (int i = 0; i < 10; i++) {
			
			//Generem un número random amb el rang del tamany del número de capitals			
			int random = 0 + (int)(Math.random() * ((paisos_capitals.size() - 0) + 1));
			
			//Escollim un pais del HashSet fent servir el número random			
			Object key = paisos_capitals.keySet().toArray()[random];
			
			//Preguntem al jugador per una resposta
			String resposta = JOptionPane.showInputDialog("Quina és la capital de: " + key);
			
			//Extra: Diem quina és la resposta correcta
			System.out.println("La respota correcta era " + paisos_capitals.get(key));
			
			//Si la resposta és la correcta, sumem 1 
			if (resposta.equalsIgnoreCase(paisos_capitals.get(key))) {
				count++;				
			}
			
			//Borrem el pais per evitar que surti repetit
			paisos_capitals.remove(key);
		}
		
		//Retornem el número de respostes correctes
		return count;
	}

	public static void resultat_quizz(String nom, int total) {
		
		try {
		      File myObj = new File("classificacio.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("Arxiu creat: " + myObj.getName());
		      } else {
		        System.out.println("L'arxiu ja existeix");
		      }
		    } catch (IOException e) {
		      System.out.println("Hi ha hagut algun error");
		      e.printStackTrace();
		    }
		
		try {
		      FileWriter myWriter = new FileWriter("classificacio.txt");
		      myWriter.write("Molt bé " + nom + ", has acertat " + total + " capitals.");
		      myWriter.close();
		      System.out.println("S'ha escrit de forma satisfactòria a l'arxiu");
		    } catch (IOException e) {
		      System.out.println("Hi ha hagut algun error");
		      e.printStackTrace();
		    }
	}
}