package GameObjects;
import Visitor.Visitor;

public abstract class Aliado extends GameObject  {

	protected int costo;
	
	
	public Aliado(int vida, int danio, int rango, int velMov, int velAt, int costo) {
		super(vida, danio, rango, velMov);
		velocidad_ataque = velAt;
		this.costo = costo;		
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public void mover() {
		// Los aliados no se mueven		
	}
	
	  
	public void setCosto(int c) { costo = c ;}
	public int getCosto() { return costo ;}
		

}
