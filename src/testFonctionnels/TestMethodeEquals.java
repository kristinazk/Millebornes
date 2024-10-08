package testFonctionnels;
import cartes.*;

public class TestMethodeEquals {

	public static void main(String[] args) {
		Borne b1 = new Borne(25);
		Borne b2 = new Borne(25);
		
		System.out.println("Deux cartes de 25km sont identiques ? " +  b1.equals(b2));
		
		Attaque fr1 = new Attaque(Type.FEU);
		Attaque fr2 = new Attaque(Type.FEU);
		
		System.out.println("Deux cartes de feux rouge sont identiques ?" + fr1.equals(fr2));
		
		Parade fv = new Parade(Type.FEU);
		
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? " + fr1.equals(fv));
	}
}
