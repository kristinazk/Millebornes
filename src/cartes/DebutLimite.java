package cartes;

public class DebutLimite extends Limite {
	
	@Override
	public String toString() {
		return "Debut Limite";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof DebutLimite) return true;
		return false;
	}
}
