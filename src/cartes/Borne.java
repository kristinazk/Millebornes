package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		super();
		this.km = km;
	}
	
	public int getKm() {
		return km;
	}
	
	@Override
	public String toString(){
		return "km: " + km;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne) {
			Borne bornePasse = (Borne)obj;
			
			if(bornePasse.getKm() == km) return true;
		}
		
		return false;
	}

}
