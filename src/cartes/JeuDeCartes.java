package cartes;

public class JeuDeCartes extends Carte {
	private Configuration typesDeCartes[];
	
	public JeuDeCartes() {
		typesDeCartes = new Configuration[] {
				new Configuration(new Borne(25), 10),
				new Configuration(new Borne(50), 10),
				new Configuration(new Borne(75), 10),
				new Configuration(new Borne(100), 12),
				new Configuration(new Borne(200), 4),
				new Configuration(new Attaque(Type.FEU), 5),
				new Configuration(new Parade(Type.FEU), 14),
				new Configuration(new Attaque(Type.ESSENCE), 3),
				new Configuration(new Parade(Type.ESSENCE), 6),
				new Configuration(new Attaque(Type.CREVAISON), 3),
		        new Configuration(new DebutLimite(), 4),
		        new Configuration(new FinLimite(), 6),
				new Configuration(new Parade(Type.CREVAISON), 6),
				new Configuration(new Parade(Type.ACCIDENT), 6),
				new Configuration(new Attaque(Type.ACCIDENT), 3),
				new Configuration(new Botte(Type.FEU), 1),
		        new Configuration(new Botte(Type.ACCIDENT), 1),
		        new Configuration(new Botte(Type.ESSENCE), 1),
		        new Configuration(new Botte(Type.CREVAISON), 1),
				};
	}
    
    public String affichageJeuDeCartes() {
        String sortie = ""; 
        for (Configuration carte : typesDeCartes) {
            sortie += carte.getNbExemplaires() + " " + carte.getCarte() + "\n";
        }
        
        return sortie;
    }
    
    public boolean checkCount() {
    	Carte[] cartesDonnes = donnerCartes();
    	int indiceCarte = 0;
    	
    	Configuration[] cartesAttendues = typesDeCartes;
    	
    	for(Configuration carteAttendue : cartesAttendues) {
    		for(int i = 0; i < carteAttendue.getNbExemplaires(); i++) {
    			if(!cartesDonnes[indiceCarte].equals(carteAttendue.getCarte())) return false;
    			indiceCarte++;
    		}
    	}
    	
    	return true;
    	
    }
	
	public Carte[] donnerCartes() {
		int nbCartes = 0;
		
		for(Configuration carte : typesDeCartes) nbCartes += carte.getNbExemplaires();
		
		Carte[] cartes = new Carte[nbCartes];
		
		nbCartes = 0;
		for(int i = 0; i < typesDeCartes.length; i++) {
			for (int j = 0; j < typesDeCartes[i].getNbExemplaires(); j++) {
				cartes[nbCartes] = typesDeCartes[i].getCarte();
				nbCartes++;
			}
		}
		
		
		return cartes;
		}
	
	private class Configuration extends Carte{
		private int nbExemplaires;
		private Carte carte;
		
		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}
		
		public Carte getCarte() {
			return carte;
		}
		
		public int getNbExemplaires() {
			return nbExemplaires;
		}
	}
}
