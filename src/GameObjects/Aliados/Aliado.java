package GameObjects.Aliados;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	
	protected Aliado(int vida, int danio, int rango, int velMov, int velAt, int costo) {

		// vida, daño, rango, velocidad de Movimiento
		super(vida, danio, rango, velMov);
		velocidad_ataque = velAt;
		this.costo = costo;		
		herido = false;
		haceDobleDanio = false;

		
	}	
	
	public void activarOyente() {

		//accion al clickear
		
		dibujo.addMouseListener(new MouseAdapter(){			
		    public void mouseClicked(MouseEvent e){  
					
				Tienda tienda = Tienda.Instancia(null);
				if(tienda.getPuedoVender()) {
					int monedas = herido ? costo/2 : costo;	
					tienda.sumarMonedas(monedas);
					morir();
					
				}
				tienda.setPuedoVender(false);	
				tienda.estadoBotones(true);
		    }  
		}); 
		
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
			disparo.cambiarDibujo("img/disparos/disparo_angosto_potenciado.gif");
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
	
	
	public void setDobleDanio(boolean b) {
		haceDobleDanio = b;
	}
	public void setDobleOro(boolean b) {
		//no hace nada
	}
		
}
