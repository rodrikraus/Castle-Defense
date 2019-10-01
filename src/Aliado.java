
public abstract class Aliado extends Personaje {
	
	protected int costo;
	protected Visitor miVisitor;
	
	public void setCosto(int c) {
		costo = c;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public void accept(Visitor v) {
		v.visitAliado(this);
	}
	
}
