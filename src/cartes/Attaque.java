package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}
	
	@Override 
	public String toString(){
		Type type = getType();
		return type.getAttaque();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Attaque) {
			Attaque cartePasse = (Attaque)obj;
			if(cartePasse.getType() == getType()) return true;
		}
		return false;
	}
}
