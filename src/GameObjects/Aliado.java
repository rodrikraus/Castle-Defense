package GameObjects;
import Visitor.Visitor;

public abstract class Aliado extends Personaje  {
	  
	protected int costo;
	
	  
	public void setCosto(int c) {
		costo = c;
	}
	
	public int getCosto() {
		return costo;  
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
