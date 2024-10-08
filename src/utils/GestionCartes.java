package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Collections;
import java.util.Iterator;

public class GestionCartes {
	private static Random random = new Random();

	public static <T> T extraire(List<T> liste) {
		int indice = random.nextInt(liste.size());
		T elemSupprime = liste.get(indice);
		liste.remove(indice);

		return elemSupprime;

	}

	public static <T> T extraireIter(List<T> liste) {
		ListIterator<T> iter = liste.listIterator();
		int indice = random.nextInt(liste.size());

		while (iter.hasNext())
			if (iter.nextIndex() == indice) {
				T elemSupprime = iter.next();
				iter.remove();
				return elemSupprime;
			}
		return null;
	}
	
	public static <T> List<T> melanger(List<T> liste){
		List<T> listeRetour = new ArrayList<T>();
		
		
		while(!liste.isEmpty()) listeRetour.add(extraire(liste));
		
		return listeRetour;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		for(T el : liste1) {
			if(Collections.frequency(liste1, el) != Collections.frequency(liste2, el)) return false;
		}
		
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste){
		List<T> listeRetour = new ArrayList<T>();
		
		for(T el : liste) {
			if(!listeRetour.contains(el)) {
				int nbFoisPresent = Collections.frequency(liste, el);
				for(int i = 0; i < nbFoisPresent; i++) listeRetour.add(el);
			}
		}
		
		return listeRetour;
	}
	
	public static <T> boolean elementContenu(List<T> col, T el, int indexDeb) {
	    for (ListIterator<T> iterator = col.listIterator(indexDeb); iterator.hasNext();) {
	        T currentElement = iterator.next();
	        if (currentElement.equals(el)) {
	            return true;
	        }
	    }
	    return false;
	}

	public static <T> boolean verifierRassemblement(List<T> collection) {
		// Si la liste est vide on retourne true
		if(collection.size() == 0) return true;
		
	    T previousElement = collection.get(0);
	    T elemCour;

	    for (Iterator<T> iterator = collection.iterator(); iterator.hasNext();) {
	        elemCour = iterator.next();
	        if (!elemCour.equals(previousElement) && elementContenu(collection, previousElement, collection.indexOf(elemCour))) {
	            return false;
	        }
	        previousElement = elemCour;
	    }
	    return true;
	}

}
