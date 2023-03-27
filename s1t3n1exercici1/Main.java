package s1t3n1exercici1;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Creem una ArrayList
		ArrayList<Month> mesos = new ArrayList<Month>();
		
		//Afegim els mesos menys el mes d'agost
		mesos.add(new Month("Gener"));
		mesos.add(new Month("Febrer"));
		mesos.add(new Month("Març"));
		mesos.add(new Month("Abril"));
		mesos.add(new Month("Maig"));
		mesos.add(new Month("Juny"));
		mesos.add(new Month("Juliol"));
		mesos.add(new Month("Setembre"));
		mesos.add(new Month("Octubre"));
		mesos.add(new Month("Novembre"));
		mesos.add(new Month("Desembre"));
		
		//Imprimir mesos 
		imprimir_mesos(mesos);
		
		//Introduim el mes d'agost
		mesos.add(7, new Month("Agost"));
		
		//Imprimir mesos incloent el mes d'agost
		imprimir_mesos(mesos);
		
		//Convertir ArrayList a HashSet
        HashSet<String> hashSet_mesos= new HashSet<>();
        mesos.forEach(mes -> { hashSet_mesos.add(mes.getName()); });
        
        //Un HashSet per definició no permet duplicats
         
        //Imprimir HashSet fent servir un for loop
        
        System.out.println("HashSet: ");       
        for (String mes : hashSet_mesos) {
            System.out.print(mes + " ");
        }
    	System.out.println("\n");	
    	
    	// Imprimir HashSet fent servir un iterador
    	
    	Iterator<String> iterador_mesos = hashSet_mesos.iterator();
    	
    	System.out.println("HashSet: ");     	
    	while (iterador_mesos.hasNext()) {
    		System.out.print(iterador_mesos.next() + " ");
    	}
    	System.out.println("\n");    		
	}
	
	public static void imprimir_mesos(ArrayList<Month> mesos) {
		
		System.out.println("ArrayList: ");
		for (int i = 0; i < mesos.size(); i++) {
			System.out.print(mesos.get(i).getName() + " ");			
			}
		System.out.println("\n");
	}
}