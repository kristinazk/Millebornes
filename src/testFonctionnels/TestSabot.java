package testFonctionnels;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.*;
import jeu.Sabot;

public class TestSabot {
	public static void main(String[] args) {
		Sabot sab = new Sabot(20);
		
		sab.ajouterCartes(new Attaque(Type.FEU));
		sab.ajouterCartes(new Borne(200));
		sab.ajouterCartes(new Parade(Type.ESSENCE));
		sab.ajouterCartes(new Botte(Type.ESSENCE));
		
		
		
//		int nombreInit  = sab.getNbCartes();
//		for(int i = 0; i < nombreInit; i++){
//			sab.piocher();
//		}
		
		Iterator<Carte> iter = sab.iterator();
		
		while(iter.hasNext()) {
			Carte c = iter.next();
			System.out.println("Je pioche " + c);
			iter.remove();
		}
		
		 try {
             Carte cartePiochée = sab.piocher();
             System.out.println("Je pioche " + cartePiochée);
         } catch (NoSuchElementException e) {
             System.out.println("Exception: Impossible de piocher");
         }
         
		 
         try {
             sab.ajouterCartes(new Botte(Type.ACCIDENT));
         } catch (IllegalStateException e) {
             System.out.println("Impossible d'ajouter l'asDuVolant pendant l'itération.");
         }
		
	}
	
}
