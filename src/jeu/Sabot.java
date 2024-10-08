package jeu;
import cartes.Carte;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte>{
	private int nbCartes = 0;
	private Carte cartes[];
	private int nombreOperations = 0;
	
	public Sabot(int capacite) {
	cartes = new Carte[capacite];
	}
	
	public Sabot(Carte cartes[]) {
		this.cartes = cartes;
	}
	
	public int getNbCartes() {
		return nbCartes;
	}
	
	
	public Carte[] getCartes() {
		return cartes;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCartes(Carte carte) {
		if(nbCartes >= cartes.length) {
			throw new ArrayIndexOutOfBoundsException("Capacite Depasse");
		}
		else {
			cartes[nbCartes] = carte;
			nbCartes++;
		}
	}
	
	public Iterator<Carte> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte>{
		private int indiceIterateur = 0;
		private int nombreOperationsReference = nombreOperations;
		private boolean nextEffectue = false;
		
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		
		public Carte next() {
			verificationConcurrence();
			if(hasNext()){
				Carte carteRetourne = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carteRetourne;
			} 
			else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if(nbCartes < 1 ||! nextEffectue) {
				throw new IllegalStateException();
			}
			for(int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i + 1];
			}
			
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
		}
		
		private void verificationConcurrence() {
			if(nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
	}
	
	public Carte piocher() {
		Iterator <Carte> iter = this.iterator();
		
		if(iter.hasNext()) {
		
		Carte carteP = iter.next();
		System.out.println("Je pioche " + carteP);
		iter.remove();
		
		return carteP;
		}
		
		return null;
	}
	
}
