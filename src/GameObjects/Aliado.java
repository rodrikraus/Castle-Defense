package GameObjects;
import Disparos.Disparo;
import Disparos.DisparoAliado;
import Juego.Punto;
import Visitor.Visitor;

public abstract class Aliado extends GameObject  {

	protected int costo;
	
	
	public Aliado(int vida, int danio, int rango, int velMov, int velAt, int costo) {
		super(vida, danio, rango, velMov);
		velocidad_ataque = velAt;
		this.costo = costo;		
	}

	@Override
	public void atacar(GameObject obj) {
		frecuencia_ataques++;
		if(vida>0) {  // si estoy vivo, ataco		
			if(frecuencia_ataques%velocidad_ataque== 0)
				iniciarAtaque(obj);
		} 
		else
			morir();
	}

	public void iniciarAtaque(GameObject obj) { 
		flushDibujo(ruta_dibujo_ataque);		
		Punto p = new Punto(punto.getX()+ancho, punto.getY());  // -10,20
		Disparo disparo = new DisparoAliado(danio, p, rango);
		mapa.add(disparo);
		disparo.setMapa(mapa);
	}

	@Override
	public void interactuar() {
		GameObject objIntersectado = mapa.intersectaRango(this);
		if(objIntersectado != null) {
			objIntersectado.accept(visitor);
		}
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
