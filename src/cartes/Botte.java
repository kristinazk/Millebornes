package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		Type type = getType();
		return type.getBotte();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Botte) {
			Botte cartePasse = (Botte)obj;
			if(cartePasse.getType() == getType()) return true;
		}
		return false;
	}
}
