package GameObjects.Aliados;
import javax.swing.ImageIcon;

import GameObjects.GameObject;
import GameObjects.Disparos.Disparo;
import GameObjects.Disparos.DisparoAliado;
import Juego.Punto;
import Tienda.Tienda;
import Visitor.Visitor;

public abstract class Aliado extends GameObject  {

	protected boolean herido;
	protected boolean haceDobleDanio;
	
	public Aliado(int vida, int danio, int rango, int velMov, int velAt, int costo) {

		// vida, daño, rango, velocidad de Movimiento
		super(vida, danio, rango, velMov);
		velocidad_ataque = velAt;
		this.costo = costo;		
		herido = false;
		haceDobleDanio = false;
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
		Punto p = new Punto(punto.getX()+ancho-30, punto.getY());
		if(haceDobleDanio) {
			Disparo disparo = new DisparoAliado(danio*2, p, rango);
			mapa.add(disparo);
			disparo.setMapa(mapa);
		} else {
			Disparo disparo = new DisparoAliado(danio, p, rango);
			mapa.add(disparo);
			disparo.setMapa(mapa);
		}
	}

	@Override
	/*public void interactuar() {
		GameObject objIntersectado = mapa.intersectaRango(this);
		if(objIntersectado != null) {
			objIntersectado.accept(visitor);
		}
	}*/
	
	public boolean interactuar() {
		GameObject objIntersectado = mapa.intersectaRango(this);
		if(objIntersectado != null) {
		objIntersectado.accept(visitor);
		}
		return true;
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public void mover() {
		// Los aliados no se mueven		
	}
	
	public boolean getHerido() {
		return herido;
	}
	
	public void setHerido(boolean h) {
		herido = h;
	}
	
	public void toClick() {
		// Calculo las monedas a sumar
		int monedas = herido ? costo/2 : costo;				
				
		Tienda tienda = Tienda.Instancia(null);
		if(tienda.getPuedoVender()) {
			tienda.sumarMonedas(monedas);
			tienda.setPuedoVender(false);	
			morir();	
		}
	}
	
	public void setDobleDanio(boolean b) {
		haceDobleDanio = b;
	}
	public void setDobleOro(boolean b) {
		//no hace nada
	}
		
}
