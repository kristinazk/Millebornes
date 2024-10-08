package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	
	}
	
	@Override
	public String toString() {
		Type type = getType();
		return type.getParade();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Parade) {
			Parade cartePasse = (Parade)obj;
			if(cartePasse.getType() == getType()) return true;
		}
		return false;
	}
}