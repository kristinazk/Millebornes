package testFonctionnels;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

import utils.GestionCartes;
import cartes.*;


public class TestJeuDeCartes {
	
	
	public static void main(String[] args) {
		JeuDeCartes jdc = new JeuDeCartes();
//		System.out.println(jdc.affichageJeuDeCartes());
//		
//		System.out.println(jdc.checkCount());
		
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jdc.donnerCartes()) {
		listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
		+ GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? "
		+ GestionCartes.verifierRassemblement(listeCartes));
		
		
        List<Integer> testList1 = Arrays.asList();
        List<Integer> testList2 = Arrays.asList(1, 1, 2, 1, 3);
        List<Integer> testList3 = Arrays.asList(1, 4, 3, 2);
        List<Integer> testList4 = Arrays.asList(1, 1, 2, 3, 1);
        
        System.out.println("Vérif liste 1 : " + GestionCartes.verifierRassemblement(testList1));
        System.out.println("Vérif liste 2 : " + GestionCartes.verifierRassemblement(testList2));
        System.out.println("Vérif liste 3 : " + GestionCartes.verifierRassemblement(testList3));
        System.out.println("Vérif liste 4 : " + GestionCartes.verifierRassemblement(testList4));
	}
}
