package jeu;
import java.util.Arrays;
import java.util.List;

import cartes.*;
import utils.GestionCartes;

public class Jeu {
	private Sabot sab;
	
	public Jeu() {
		JeuDeCartes jdc = new JeuDeCartes();
		List<Carte> listeCartes = Arrays.asList(jdc.donnerCartes());
		List<Carte> listeCartesMelange = GestionCartes.melanger(listeCartes);
		sab = new Sabot((Carte[])listeCartesMelange.toArray());
	}
	
}
