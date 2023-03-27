package s1t3n1exercici2;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Creació d'una llista
		List<Integer> numeros1 = new ArrayList<Integer>();
		
		// Afegim elements
		numeros1.add(4);
		numeros1.add(9);
		numeros1.add(2);
		numeros1.add(5);
		numeros1.add(1);
		
		System.out.println(numeros1);
		
		//Obtenim un ListIterator i el fiquem a l'última posició
		ListIterator<Integer> numeros1Iterator = numeros1.listIterator(numeros1.size());
		
		//Creacio d'una altra llista
		List<Integer> numeros2 = new ArrayList<Integer>();
		
		//Afegim elements en ordre invers
		while (numeros1Iterator.hasPrevious()) {
				
			numeros2.add(numeros1Iterator.previous());
		}
		
		System.out.println(numeros2);
	}
}